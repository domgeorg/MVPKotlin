package gr.mobile.mvp.kotlin.common.delegates.base

import java.lang.ref.WeakReference

open class BaseDelegate<T> {

    protected var weakReference: WeakReference<T>?

    constructor(reference: T) {
        weakReference = WeakReference(reference)
    }

    fun attach(reference: T) {
        weakReference?.clear()
        weakReference = WeakReference(reference)
    }

    fun detach() {
        weakReference?.clear()
        weakReference = null
    }

    fun isAttached(): Boolean {
        return weakReference != null && weakReference?.get() != null
    }


    fun getReference(): T? {
        return weakReference?.get()
    }
}