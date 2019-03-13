package gr.mobile.mvp.kotlin.mvp.view.base

interface MvpView {

    fun isAttached(): Boolean

    fun showLoading()

    fun showData()

    fun showEmpty()

    fun showError(error: String)

    fun showNoInternetError()

    fun showGenericError()
}