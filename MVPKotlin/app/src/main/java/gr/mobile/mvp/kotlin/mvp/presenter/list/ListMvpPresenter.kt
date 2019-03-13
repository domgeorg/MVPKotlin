package gr.mobile.mvp.kotlin.mvp.presenter.list

import gr.mobile.mvp.kotlin.mvp.interactor.list.ListMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.list.ListMvpView

interface ListMvpPresenter : MvpPresenter<ListMvpView, ListMvpInteractor> {

    fun getSpeakers()
}