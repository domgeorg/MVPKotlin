package gr.mobile.mvp.kotlin.mvp.interactor.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseInteractor : MvpInteractor {

    private var compositeDisposable: CompositeDisposable? = null

    constructor() {
        compositeDisposable = CompositeDisposable()
    }

    fun makeRequest(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }

    override fun detach() {
        compositeDisposable?.dispose()
        compositeDisposable?.clear()
        compositeDisposable = CompositeDisposable()
    }

}