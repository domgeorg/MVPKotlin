package gr.mobile.mvp.kotlin.mvp.presenter.details

import gr.mobile.mvp.kotlin.mvp.interactor.details.DetailsMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.details.DetailsMvpView

class DetailsMvpPresenterImpl : DetailsMvpPresenter, MvpPresenterImpl<DetailsMvpView, DetailsMvpInteractor> {

    constructor(view: DetailsMvpView, interactor: DetailsMvpInteractor) : super(view, interactor)

    override fun getSpeakerEvent() {
        if (!isViewAttached()) {
            return
        }
        getView()?.showLoading()
        getInteractor()?.getSpeakerEventDetails(
            {speakerEvent -> getView()?.showSpeakerDetails(speakerEvent) },
            {throwable -> getView()?.showError(throwable.localizedMessage) }
        )
    }

}