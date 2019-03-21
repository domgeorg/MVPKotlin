package gr.mobile.mvp.kotlin.network.client

import gr.mobile.mvp.kotlin.BuildConfig
import gr.mobile.mvp.kotlin.common.Definitions
import gr.mobile.mvp.kotlin.network.api.Api
import gr.mobile.mvp.kotlin.network.error.RxErrorHandlingCallAdapterFactory
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.ArticleLeadsResponse
import gr.mobile.mvp.kotlin.network.parser.response.categories.CategoriesResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Client {

    var api: Api? = null

    fun createApi(): Client {

        if (api == null) {
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl(Definitions.DOMAIN)
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClientBuilder().build())
                .build()
            api = retrofitBuilder.create<Api>(Api::class.java)
        }
        return this
    }

    private fun getOkHttpClientBuilder(): OkHttpClient.Builder {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.connectTimeout(Definitions.CLIENT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        httpClientBuilder.readTimeout(Definitions.CLIENT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        httpClientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))

        return httpClientBuilder
    }

    fun getCategories(): Observable<CategoriesResponse>? {
        return api?.getCategories()
    }

    fun getArticles(): Observable<ArticleLeadsResponse>? {
        return api?.getArticles()
    }
}