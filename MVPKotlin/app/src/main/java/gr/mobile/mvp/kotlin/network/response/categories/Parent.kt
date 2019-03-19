package gr.mobile.mvp.kotlin.network.response.categories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Parent(
    @SerializedName("PageOrder")
    val pageOrder: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("parent_id")
    val parentId: Int
) : Parcelable