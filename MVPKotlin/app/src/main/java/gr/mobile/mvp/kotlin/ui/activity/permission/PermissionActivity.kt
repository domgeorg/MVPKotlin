package gr.mobile.mvp.kotlin.ui.activity.permission

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.common.Definitions
import gr.mobile.mvp.kotlin.common.delegates.permission.PermissionAction
import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.permission.PermissionMvpPresenter
import gr.mobile.mvp.kotlin.mvp.presenter.permission.PermissionMvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.permission.PermissionMvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : BaseActivity<PermissionMvpPresenter>(), PermissionMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        presenter = PermissionMvpPresenterImpl(this, EmptyMvpInteractorImpl())
        initLayout()
    }

    private fun initLayout() {
        permissionButton.setOnClickListener {
            presenter?.onPermissionClicked()
        }
    }

    override fun checkForPermission() {
        permissionDelegate.executeActionWithPermission(object : PermissionAction {
            override fun onPermissionGranted() {
                Toast.makeText(this@PermissionActivity, "onPermissionGranted", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionRejected() {
                Toast.makeText(this@PermissionActivity, "onPermissionRejected", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionNeverAskAgainChecked() {
                Toast.makeText(this@PermissionActivity, "onPermissionNeverAskAgainChecked", Toast.LENGTH_SHORT).show()
            }

            override fun getRequestedPermissions(): Array<String> {
                return arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
            }

            override fun getPermissionRequestCode(): Int {
                return Definitions.REQUEST_RUNTIME_LOCATION
            }
        })
    }
}