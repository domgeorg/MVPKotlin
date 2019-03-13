package gr.mobile.mvp.kotlin.mvp.presenter.list

import gr.mobile.mvp.kotlin.mvp.interactor.list.ListMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.list.ListMvpView

class ListMvpPresenterImpl : ListMvpPresenter, MvpPresenterImpl<ListMvpView, ListMvpInteractor> {

    constructor(view: ListMvpView, interactor: ListMvpInteractor) : super(view, interactor)

    override fun getSpeakers() {
        if (!isViewAttached()) {
            return
        }
        getView()?.showLoading()
        getInteractor()?.getSpeakers(
            { speakers -> getView()?.showSpeaker(speakers) },
            { throwable -> getView()?.showError(throwable.localizedMessage) }
        )
    }

}