package gr.mobile.mvp.kotlin.mvp.view.details

import gr.mobile.mvp.kotlin.model.SpeakerEvent
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView

interface DetailsMvpView : MvpView {

    fun showSpeakerDetails(speakerEvent: SpeakerEvent)
}