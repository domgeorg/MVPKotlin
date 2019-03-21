package gr.mobile.mvp.kotlin.mvp.presenter.menu

import gr.mobile.mvp.kotlin.mvp.interactor.menu.MenuMvpInteractor
import gr.mobile.mvp.kotlin.mvp.interactor.menu.MenuMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.menu.MenuMvpView

class MenuMvpPresenterImpl : MvpPresenterImpl<MenuMvpView, MenuMvpInteractor>, MenuMvpPresenter {

    constructor(view: MenuMvpView, interactor: MenuMvpInteractorImpl) : super(view, interactor)

    override fun onListClicked() {
        getView()?.goToListScreen()
    }

    override fun onPermissionClicked() {
        getView()?.goToPermissionScreen()
    }

    override fun onFragmentClicked() {
        getView()?.goToFragmentScreen()
    }

    override fun getCategories() {
        if (!isViewAttached()) {
            return
        }
        getInteractor()?.getCategories({
            getView()?.showCategories(it)
        }, {
            getView()?.showError(it.localizedMessage)
        }
        )
    }
}