package gr.mobile.mvp.kotlin.common.utils.app

import android.os.Build

class AppUtils {
    companion object {
        fun isMarshmallow(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        }
    }
}