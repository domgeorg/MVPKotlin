package gr.mobile.mvp.kotlin.mvp.interactor.list

import gr.mobile.mvp.kotlin.model.Speaker
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor

interface ListMvpInteractor : MvpInteractor {

    fun getSpeakers(successCallback: (ArrayList<Speaker>) -> Unit, errorCallback: (Throwable) -> Unit)
}