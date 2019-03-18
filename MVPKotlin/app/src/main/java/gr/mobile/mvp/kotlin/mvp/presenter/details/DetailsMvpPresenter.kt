package gr.mobile.mvp.kotlin.mvp.presenter.details

import gr.mobile.mvp.kotlin.mvp.interactor.details.DetailsMvpInteractor
import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.details.DetailsMvpView

interface DetailsMvpPresenter : MvpPresenter<DetailsMvpView, EmptyMvpInteractor> {

    fun getSpeakerEvent()

}