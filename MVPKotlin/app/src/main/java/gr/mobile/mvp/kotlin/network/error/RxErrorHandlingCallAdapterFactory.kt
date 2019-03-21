package gr.mobile.mvp.kotlin.network.error

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.HttpException
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.lang.reflect.Type

class RxErrorHandlingCallAdapterFactory() : CallAdapter.Factory() {

    private val original by lazy {
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    companion object {
        fun create(): CallAdapter.Factory = RxErrorHandlingCallAdapterFactory()
    }

    /**
     * Returns a call adapter for interface methods that return `returnType`, or null if it
     * cannot be handled by this factory.
     */
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? =
        RxCallAdapterWrapper(
            retrofit,
            original.get(returnType, annotations, retrofit) as CallAdapter<out Any, *> as CallAdapter<out Any, Any>
        )


    private class RxCallAdapterWrapper<R>(
        private val retrofit: Retrofit,
        private val wrapped: CallAdapter<R, Any>
    ) : CallAdapter<R, Any> {

        override fun responseType(): Type = wrapped.responseType()

        @SuppressLint("CheckResult")
        override fun adapt(call: Call<R>): Observable<R> {
            val adapted = (wrapped.adapt(call) as Observable<R>)
            adapted.onErrorResumeNext { throwable: Throwable ->
                Observable.error(asRetrofitException(throwable))
            }
            return adapted
        }

        private fun asRetrofitException(throwable: Throwable): RetrofitException {
            // We had non-200 http error
            if (throwable is HttpException) {
                val response = throwable.response()
                return RetrofitException.httpError(response.raw().request().url().toString(), response, retrofit)
            }
            // A network error happened
            return if (throwable is IOException) {
                RetrofitException.networkError(throwable)
            }

            // We don't know what happened. We need to simply convert to an unknown error
            else RetrofitException.unexpectedError(throwable)
        }
    }
}