package gr.mobile.mvp.kotlin.common.delegates.permission

interface PermissionAction {
    fun onPermissionGranted()

    fun onPermissionRejected()

    fun onPermissionNeverAskAgainChecked()

    fun getRequestedPermissions(): Array<String>

    fun getPermissionRequestCode(): Int
}