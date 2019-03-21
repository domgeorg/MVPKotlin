package gr.mobile.mvp.kotlin.network.parser.response.categories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import gr.mobile.mvp.kotlin.network.parser.CommonParser
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoriesResponse(
    @SerializedName("articleCategories")
    val categories: List<Category>,

    @Transient
    override var success: Boolean,

    @Transient
    override var error: Error
) : Parcelable, CommonParser(success, error)