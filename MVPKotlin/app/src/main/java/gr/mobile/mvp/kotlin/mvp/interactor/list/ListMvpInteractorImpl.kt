package gr.mobile.mvp.kotlin.mvp.interactor.list

import gr.mobile.mvp.kotlin.model.Speaker
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractorImpl
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ListMvpInteractorImpl : MvpInteractorImpl(), ListMvpInteractor {

    private val speakers: ArrayList<Speaker> = arrayListOf()

    init {
        for (i in 1..100) {
            speakers.add(Speaker("name $i", "title $i", "description $i"))
        }
    }

    override fun getSpeakers(successCallback: (ArrayList<Speaker>) -> Unit, errorCallback: (Throwable) -> Unit) {
        makeRequest(Observable.create<ArrayList<Speaker>> { subscriber ->
            subscriber.onNext(speakers)
            subscriber.onComplete()
        }
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                successCallback.invoke(it)
            }, {
                errorCallback.invoke(it)
            }))
    }
}