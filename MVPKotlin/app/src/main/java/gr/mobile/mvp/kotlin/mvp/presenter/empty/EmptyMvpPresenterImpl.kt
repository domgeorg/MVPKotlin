package gr.mobile.mvp.kotlin.mvp.presenter.empty

import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView

class EmptyMvpPresenterImpl : EmptyMvpPresenter, MvpPresenterImpl<MvpView, EmptyMvpInteractor> {
    constructor(view: MvpView, interactor: EmptyMvpInteractor) : super(view, interactor)
}