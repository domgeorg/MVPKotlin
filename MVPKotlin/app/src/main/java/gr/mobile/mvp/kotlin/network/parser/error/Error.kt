package gr.mobile.mvp.kotlin.network.parser.error

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("error")
    var error: String? = null
)