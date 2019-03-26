package gr.mobile.mvp.kotlin.common.extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun dateFormatted(dateInMillis: Long?, dateFormat: String): String = SimpleDateFormat(dateFormat).format(dateInMillis?.let { Date(it) })