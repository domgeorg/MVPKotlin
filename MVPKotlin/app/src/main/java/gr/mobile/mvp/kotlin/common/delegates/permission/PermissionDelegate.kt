package gr.mobile.mvp.kotlin.common.delegates.permission

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import java.lang.ref.WeakReference

class PermissionDelegate(activity: AppCompatActivity) {

    private var activityRef: WeakReference<AppCompatActivity>
    private var permissionActions: ArrayList<PermissionAction>

    init {
        activityRef = WeakReference(activity)
        permissionActions = arrayListOf()
    }

    fun executeActionWithPermission(permissionAction: PermissionAction) {
        if (!isAttached()) {
            return
        }
        getActivity()?.let {
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

    private fun getActivity(): Activity? {
        return activityRef.get()
    }

    private fun isAttached(): Boolean {
        return activityRef.get() != null
    }

    private fun isPermissionGrantedForAction(permissionAction: PermissionAction): Boolean {
        getActivity()?.let {
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
        getActivity()?.let {
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