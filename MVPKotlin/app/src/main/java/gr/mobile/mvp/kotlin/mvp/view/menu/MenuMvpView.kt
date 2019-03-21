package gr.mobile.mvp.kotlin.mvp.view.menu

import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.network.parser.response.categories.CategoriesResponse

interface MenuMvpView : MvpView {

    fun goToListScreen()

    fun goToPermissionScreen()

    fun goToFragmentScreen()

    fun showCategories(categories: CategoriesResponse)
}