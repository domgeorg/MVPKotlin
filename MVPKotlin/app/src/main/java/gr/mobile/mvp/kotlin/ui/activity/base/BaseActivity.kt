package gr.mobile.mvp.kotlin.ui.activity.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.common.delegates.fragmentManager.FragmentManagerDelegate
import gr.mobile.mvp.kotlin.common.delegates.permission.PermissionDelegate
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.network.client.Client
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_list.*

@SuppressLint("Registered")
open class BaseActivity<T : MvpPresenter<MvpView, MvpInteractor>> : AppCompatActivity(), MvpView {

    protected var presenter: T? = null

    lateinit var compositeDisposable: CompositeDisposable

    val permissionDelegate: PermissionDelegate by lazy {
        return@lazy PermissionDelegate(this)
    }
    val fragmentManagerDelegate: FragmentManagerDelegate by lazy {
        return@lazy FragmentManagerDelegate(supportFragmentManager, R.id.fragmentContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    protected fun makeRequest(disposable: Disposable?) {
        disposable?.let { compositeDisposable.add(it) }
    }

    override fun isAttached(): Boolean {
        return !isFinishing
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        permissionDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults)
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