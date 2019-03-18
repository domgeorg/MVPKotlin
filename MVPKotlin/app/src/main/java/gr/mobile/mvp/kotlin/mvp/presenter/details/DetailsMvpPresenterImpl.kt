package gr.mobile.mvp.kotlin.mvp.presenter.details

import gr.mobile.mvp.kotlin.mvp.interactor.details.DetailsMvpInteractor
import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.details.DetailsMvpView

class DetailsMvpPresenterImpl : DetailsMvpPresenter, MvpPresenterImpl<DetailsMvpView, EmptyMvpInteractor> {

    constructor(view: DetailsMvpView, interactor: EmptyMvpInteractor) : super(view, interactor)

    override fun getSpeakerEvent() {
        if (!isViewAttached()) {
            return
        }
        getView()?.showLoading()
            getView()?.showSpeakerDetails()
    }

}