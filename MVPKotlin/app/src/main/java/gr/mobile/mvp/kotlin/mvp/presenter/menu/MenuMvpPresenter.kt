package gr.mobile.mvp.kotlin.mvp.presenter.menu

import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractor
import gr.mobile.mvp.kotlin.mvp.interactor.menu.MenuMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.menu.MenuMvpView

interface MenuMvpPresenter : MvpPresenter<MenuMvpView, MenuMvpInteractor> {

    fun onListClicked()

    fun onPermissionClicked()

    fun onFragmentClicked()

    fun getCategories()
}