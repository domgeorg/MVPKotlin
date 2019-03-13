package gr.mobile.mvp.kotlin.mvp.presenter.base

interface MvpPresenter<out V, out I> {

    fun detach()

    fun getView(): V?

    fun getInteractor(): I?

    fun isViewAttached(): Boolean
}