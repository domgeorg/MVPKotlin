package gr.mobile.mvp.kotlin.mvp.presenter.menu

import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.menu.MenuMvpView

interface MenuMvpPresenter : MvpPresenter<MenuMvpView, EmptyMvpInteractor> {

    fun onListClicked()

    fun onPermissionClicked()
}