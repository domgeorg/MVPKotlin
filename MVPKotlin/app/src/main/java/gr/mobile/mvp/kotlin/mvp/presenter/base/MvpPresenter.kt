package gr.mobile.mvp.kotlin.mvp.presenter.base

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView

interface MvpPresenter<V : MvpView, I : MvpInteractor> {

    fun detach()

    fun getView(): V?

    fun getInteractor(): I?

    fun isViewAttached(): Boolean
}