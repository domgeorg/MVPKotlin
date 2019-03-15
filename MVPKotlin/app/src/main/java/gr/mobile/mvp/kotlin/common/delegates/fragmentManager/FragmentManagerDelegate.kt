package gr.mobile.mvp.kotlin.common.delegates.fragmentManager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import gr.mobile.mvp.kotlin.common.Definitions
import gr.mobile.mvp.kotlin.common.delegates.base.BaseDelegate
import gr.mobile.mvp.kotlin.ui.fragment.base.BaseFragment

class FragmentManagerDelegate(fragmentManager: FragmentManager, private val fragmentContainerId: Int) :
    BaseDelegate<FragmentManager>(fragmentManager) {

    fun getCurrentBaseFragment(): BaseFragment<*>? {
        if (!isAttached()) {
            return null
        }
        val reference = getReference()
        if (reference != null && reference.backStackEntryCount > 0) {
            val currentFragment = getReference()?.findFragmentById(fragmentContainerId)
            if (currentFragment != null && currentFragment is BaseFragment<*>) {
                return currentFragment
            }
        }
        return null
    }

    fun onBackPressed(): Boolean {
        if (!isAttached()) {
            return false
        }
        val reference = getReference()
        if (reference != null && reference.backStackEntryCount > 1) {
            val currentBaseFragment = getCurrentBaseFragment()
            if (currentBaseFragment != null && currentBaseFragment.onBackPressed()) {
                return true
            }
            popBackStack()
            return true
        }
        return false
    }

    fun <T : BaseFragment<*>> addFragment(
        baseFragment: T,
        backStackTag: String = Definitions.BACKSTACK_GLOBAL,
        enterAnim: Int = 0,
        exitAnim: Int = 0
    ) {
        if (!isAttached()) {
            return
        }
        checkAndTriggerCurrentFragmentOnPause()
        val fragmentTransaction = getReference()?.beginTransaction()

        if (enterAnim != 0 && exitAnim != 0) {
            fragmentTransaction?.setCustomAnimations(enterAnim, exitAnim, enterAnim, exitAnim)
        }

        fragmentTransaction
            ?.add(fragmentContainerId, baseFragment, backStackTag)
            ?.addToBackStack(backStackTag)
            ?.commitAllowingStateLoss()
    }

    fun <T : BaseFragment<*>> replaceFragment(
        baseFragment: T,
        backStackTag: String = Definitions.BACKSTACK_GLOBAL,
        enterAnim: Int = 0,
        exitAnim: Int = 0
    ) {
        if (!isAttached()) {
            return
        }
        checkAndTriggerCurrentFragmentOnPause()
        val fragmentTransaction = getReference()?.beginTransaction()

        if (enterAnim != 0 && exitAnim != 0) {
            fragmentTransaction?.setCustomAnimations(enterAnim, 0, 0, exitAnim)
        }

        fragmentTransaction
            ?.replace(fragmentContainerId, baseFragment)
            ?.addToBackStack(backStackTag)
            ?.commitAllowingStateLoss()
    }

    fun <T : BaseFragment<*>> removeFragment(baseFragment: T, backStackTag: String?) {
        if (!isAttached()) {
            return
        }
        val fragmentTransaction = getReference()?.beginTransaction()
        baseFragment.onBackStackPause()
        fragmentTransaction?.remove(baseFragment)
        if (backStackTag != null) {
            fragmentTransaction?.addToBackStack(backStackTag)
        }
        fragmentTransaction?.commitAllowingStateLoss()
    }

    fun <T : BaseFragment<*>> showFragment(baseFragment: T?, vararg fragmentsToHide: T?) {
        if (!isAttached() || baseFragment == null || !baseFragment.isAdded) {
            return
        }
        val fragmentTransaction = getReference()?.beginTransaction()
        fragmentTransaction?.show(baseFragment)
        for (fragmentToHide in fragmentsToHide) {
            if (fragmentToHide != null && fragmentToHide.isAdded) {
                fragmentTransaction?.hide(fragmentToHide)
            }
        }
        fragmentTransaction?.commitAllowingStateLoss()
    }

    fun <T : BaseFragment<*>> showOrAddFragment(
        baseFragment: T,
        backStackTag: String = Definitions.BACKSTACK_GLOBAL,
        enterAnim: Int = 0,
        exitAnim: Int = 0,
        vararg fragmentsToHide: T?
    ) {
        if (!isAttached()) {
            return
        }
        if (baseFragment.isAdded) {
            showFragment(baseFragment, *fragmentsToHide)
        } else {
            addFragment(baseFragment, backStackTag, enterAnim, exitAnim)
        }
        baseFragment.setVisibleToUser(true)
        for (hiddenFragment in fragmentsToHide) {
            hiddenFragment?.setVisibleToUser(false)
        }
    }

    fun popBackStack(backStackTag: String, flags: Int) {
        if (!isAttached()) {
            return
        }
        checkAndTriggerCurrentFragmentOnPause()
        getReference()?.popBackStack(backStackTag, flags)
    }

    fun getAllFragments(): List<Fragment>? {
        if (!isAttached()) {
            return null
        }
        return getReference()?.fragments
    }

    private fun popBackStack() {
        if (!isAttached()) {
            return
        }
        checkAndTriggerCurrentFragmentOnPause()
        getReference()?.popBackStack()
    }

    private fun checkAndTriggerCurrentFragmentOnPause() {
        if (!isAttached()) {
            return
        }
        getCurrentBaseFragment()?.onBackStackPause()
    }

    private fun checkAndTriggerCurrentFragmentOnResume() {
        if (!isAttached()) {
            return
        }
        getCurrentBaseFragment()?.onBackStackResume()
    }

    private fun getFragmentByTag(tag: String?): Fragment? {
        if (!isAttached()) {
            return null
        }
        return getReference()?.findFragmentByTag(tag)
    }
}