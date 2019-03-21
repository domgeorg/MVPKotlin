package gr.mobile.mvp.kotlin.network.parser

open class CommonParser(
    open var success: Boolean,

    open var error: Error
) {

    fun isSuccess(): Boolean = success
}