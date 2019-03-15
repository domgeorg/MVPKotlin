package gr.mobile.mvp.kotlin.mvp.interactor.details

import gr.mobile.mvp.kotlin.model.SpeakerEvent
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractorImpl
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DetailsMvpInteractorImpl : MvpInteractorImpl(), DetailsMvpInteractor {

    override fun getSpeakerEventDetails(successCallback: (SpeakerEvent) -> Unit, errorCallback: (Throwable) -> Unit) {
        makeRequest(Observable.create<SpeakerEvent> { subscriber ->
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