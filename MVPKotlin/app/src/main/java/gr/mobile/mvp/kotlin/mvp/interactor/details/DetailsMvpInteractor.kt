package gr.mobile.mvp.kotlin.mvp.interactor.details

import gr.mobile.mvp.kotlin.model.SpeakerEvent
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import javax.security.auth.callback.Callback

interface DetailsMvpInteractor : MvpInteractor {

    fun getSpeakerEventDetails(successCallback: (SpeakerEvent) -> Unit, errorCallback: (Throwable)-> Unit)
}