package gr.mobile.mvp.kotlin.mvp.presenter.permission

import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.permission.PermissionMvpView

class PermissionMvpPresenterImpl : MvpPresenterImpl<PermissionMvpView, EmptyMvpInteractor>, PermissionMvpPresenter {

    constructor(view: PermissionMvpView, interactor: EmptyMvpInteractor) : super(view, interactor)

    override fun onPermissionClicked() {
        getView()?.checkForPermission()
    }
}