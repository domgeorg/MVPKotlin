package gr.mobile.mvp.kotlin.mvp.interactor.menu

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractorImpl
import gr.mobile.mvp.kotlin.network.client.Client
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MenuMvpInteractorImpl(val client: Client) : MvpInteractorImpl(), MenuMvpInteractor {

    override fun getCategories() {
            makeRequest(client.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {  }))
    }
}