package gr.mobile.mvp.kotlin.mvp.view.list

import gr.mobile.mvp.kotlin.model.Speaker
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView

interface ListMvpView : MvpView {

    fun showSpeaker(speakers: ArrayList<Speaker>)
}