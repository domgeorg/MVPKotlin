package gr.mobile.mvp.kotlin.ui.fragment.base

import android.support.v4.app.Fragment
import android.widget.Toast
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.common.delegates.fragmentManager.FragmentManagerDelegate
import gr.mobile.mvp.kotlin.common.delegates.permission.PermissionDelegate
import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity

open class BaseFragment<T : MvpPresenter<MvpView, MvpInteractor>> : Fragment(), MvpView {

    protected var presenter: T? = null
    private var isVisibleToUser: Boolean = false

    val permissionDelegate: PermissionDelegate?
        get() = getBaseActivity()?.permissionDelegate

    val fragmentManagerDelegate: FragmentManagerDelegate by lazy {
        return@lazy FragmentManagerDelegate(childFragmentManager, R.id.fragmentContainer)
    }

    override fun isAttached(): Boolean {
        return activity != null && activity!!.isFinishing && isAdded
    }

    override fun showLoading() {
    }

    override fun showData() {
    }

    override fun showEmpty() {
    }

    override fun showError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show()
    }

    override fun showNoInternetError() {
        Toast.makeText(activity, "No Internet", Toast.LENGTH_SHORT).show()
    }

    override  fun showGenericError() {
        Toast.makeText(activity, "Oupsies! Something went wrong", Toast.LENGTH_SHORT).show()
    }

    protected fun getBaseActivity(): BaseActivity<*>? {
        return activity as? BaseActivity<*> ?: return null
    }

    open fun onBackStackResume() {
    }

    open fun onBackStackPause() {
    }

    fun onBackPressed(): Boolean {
        return fragmentManagerDelegate.onBackPressed()
    }

    @Synchronized
    fun setVisibleToUser(visibleToUser: Boolean) {
        isVisibleToUser = visibleToUser
    }

    @Synchronized
    fun isVisibleToUser(): Boolean {
        return isVisibleToUser
    }
}