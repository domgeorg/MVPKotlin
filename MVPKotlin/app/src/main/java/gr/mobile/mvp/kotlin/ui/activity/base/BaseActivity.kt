package gr.mobile.mvp.kotlin.ui.activity.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import kotlinx.android.synthetic.main.activity_list.*

@SuppressLint("Registered")
open class BaseActivity<T : MvpPresenter<MvpView, MvpInteractor>> : AppCompatActivity(), MvpView {

    protected var presenter: T? = null

    override fun isAttached(): Boolean {
        return !isFinishing
    }

    override fun showLoading() {
        loadingView?.visibility = View.VISIBLE
        emptyView?.visibility = View.GONE
    }

    override fun showData() {
        loadingView?.visibility = View.GONE
        emptyView?.visibility = View.GONE
    }

    override fun showEmpty() {
        loadingView?.visibility = View.GONE
        emptyView?.visibility = View.VISIBLE
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showNoInternetError() {
        Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()
    }

    override fun showGenericError() {
        Toast.makeText(this, "Oupsies! Something went wrong", Toast.LENGTH_SHORT).show()
    }
}