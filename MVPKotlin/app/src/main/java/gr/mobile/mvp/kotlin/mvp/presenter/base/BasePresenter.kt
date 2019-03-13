package gr.mobile.mvp.kotlin.mvp.presenter.base

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import java.lang.ref.WeakReference

class BasePresenter<V : MvpView, I : MvpInteractor> : MvpPresenter<V, I> {

    private var viewRef: WeakReference<V>? = null
    private var interactor: I? = null

    constructor(view: V, interactor: I) {
        this.viewRef = WeakReference(view)
        this.interactor = interactor
    }

    override fun detach() {
        viewRef?.clear()
        interactor?.detach()
    }

    override fun getView(): V? {
        return viewRef?.get()
    }

    override fun getInteractor(): I? {
        return interactor
    }

    override fun isViewAttached(): Boolean {
        return viewRef != null && viewRef!!.get() != null && viewRef!!.get()!!.isAttached()
    }

}