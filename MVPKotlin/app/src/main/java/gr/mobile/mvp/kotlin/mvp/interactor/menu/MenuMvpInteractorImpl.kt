package gr.mobile.mvp.kotlin.mvp.interactor.menu

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractorImpl
import gr.mobile.mvp.kotlin.network.client.Client
import gr.mobile.mvp.kotlin.network.parser.response.categories.CategoriesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MenuMvpInteractorImpl(private val client: Client) : MvpInteractorImpl(), MenuMvpInteractor {

    override fun getCategories(successCallback: (CategoriesResponse) -> Unit, errorCallback: (Throwable) -> Unit) {
        client.getCategories()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { successCallback.invoke(it) },
                { errorCallback.invoke(it) }
            )?.let {
                makeRequest(it)
            }
    }
}