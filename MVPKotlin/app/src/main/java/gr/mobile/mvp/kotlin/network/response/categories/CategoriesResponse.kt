package gr.mobile.mvp.kotlin.network.response.categories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<Category>
):Parcelable