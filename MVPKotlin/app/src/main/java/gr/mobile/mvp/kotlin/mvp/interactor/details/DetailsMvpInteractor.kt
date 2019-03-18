package gr.mobile.mvp.kotlin.mvp.interactor.details

import gr.mobile.mvp.kotlin.model.SpeakerEvent
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor

interface DetailsMvpInteractor : MvpInteractor {

    fun getSpeakerEventDetails(successCallback: (SpeakerEvent) -> Unit, errorCallback: (Throwable)-> Unit)
}