package gr.mobile.mvp.kotlin.mvp.presenter.permission

import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.permission.PermissionMvpView

interface PermissionMvpPresenter : MvpPresenter<PermissionMvpView, EmptyMvpInteractor> {

    fun onPermissionClicked()
}