package gr.mobile.mvp.kotlin.ui.activity.base

import android.annotation.SuppressLint
import android.content.Intent
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
import kotlinx.android.synthetic.main.layout_empty.*
import kotlinx.android.synthetic.main.layout_loading.*

@SuppressLint("Registered")
open class BaseActivity<T : MvpPresenter<MvpView, MvpInteractor>> : AppCompatActivity(), MvpView {

    protected var presenter: T? = null

    val permissionDelegate: PermissionDelegate by lazy {
        return@lazy PermissionDelegate(this)
    }
    val fragmentManagerDelegate: FragmentManagerDelegate by lazy {
        return@lazy FragmentManagerDelegate(supportFragmentManager, R.id.fragmentContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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

    fun startActivityModal(intent: Intent) {
        startActivity(intent)
        overridePendingTransition(R.anim.anim_slide_up, R.anim.anim_zoom_out)
    }

    fun startActivityModal(intent: Intent, bundle: Bundle?) {
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.anim_slide_up, R.anim.anim_zoom_out)
    }

    fun startActivityForResultModal(intent: Intent, code: Int, bundle: Bundle?) {
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, code)
        overridePendingTransition(R.anim.anim_slide_up, R.anim.anim_zoom_out)
    }

    fun startActivityAsSlide(intent: Intent, bundle: Bundle?) {
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left)
    }

    fun startActivityForResultAsSlide(intent: Intent, code: Int, bundle: Bundle?) {
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, code)
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left)
    }

}