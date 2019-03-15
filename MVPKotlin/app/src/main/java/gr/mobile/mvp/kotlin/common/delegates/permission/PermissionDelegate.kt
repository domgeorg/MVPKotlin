package gr.mobile.mvp.kotlin.common.delegates.permission

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import gr.mobile.mvp.kotlin.common.delegates.base.BaseDelegate

class PermissionDelegate(activity: AppCompatActivity) : BaseDelegate<AppCompatActivity>(activity) {

    private val permissionActions: ArrayList<PermissionAction>

    init {
        permissionActions = arrayListOf()
    }

    fun executeActionWithPermission(permissionAction: PermissionAction) {
        if (!isAttached()) {
            return
        }
        getReference()?.let {
            if (isPermissionGrantedForAction(permissionAction)) {
                permissionAction.onPermissionGranted()
            } else {
                permissionActions.add(permissionAction)
                ActivityCompat.requestPermissions(
                    it,
                    permissionAction.getRequestedPermissions(),
                    permissionAction.getPermissionRequestCode()
                )
            }
        }
    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (!isAttached()) {
            return
        }
        getPermissionActionByCode(requestCode)?.let { permissionAction ->
            permissionActions.remove(permissionAction)
            if (isPermissionGrantedForAction(permissionAction)) {
                permissionAction.onPermissionGranted()
            } else {
                if (!shouldShowRequestPermissionRationale(permissionAction)) {
                    permissionAction.onPermissionNeverAskAgainChecked()
                } else {
                    permissionAction.onPermissionRejected()
                }
            }
        }
    }

    private fun isPermissionGrantedForAction(permissionAction: PermissionAction): Boolean {
        getReference()?.let {
            for (permissionResult: String in permissionAction.getRequestedPermissions()) {
                if (ActivityCompat.checkSelfPermission(it, permissionResult) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
            return true
        }
        return false
    }

    private fun getPermissionActionByCode(requestCode: Int): PermissionAction? {
        if (!isAttached()) {
            return null
        }
        for (permissionAction in permissionActions) {
            if (requestCode == permissionAction.getPermissionRequestCode()) {
                return permissionAction
            }
        }
        return null
    }

    private fun shouldShowRequestPermissionRationale(permissionAction: PermissionAction): Boolean {
        getReference()?.let {
            for (permission in permissionAction.getRequestedPermissions()) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(it, permission)) {
                    return false
                }
            }
            return true
        }
        return false
    }
}