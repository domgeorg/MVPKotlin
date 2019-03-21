package gr.mobile.mvp.kotlin.mvp.interactor.menu

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.network.parser.response.categories.CategoriesResponse

interface MenuMvpInteractor : MvpInteractor {

    fun getCategories(successCallback: (CategoriesResponse) -> Unit, errorCallback: (Throwable) -> Unit)
}