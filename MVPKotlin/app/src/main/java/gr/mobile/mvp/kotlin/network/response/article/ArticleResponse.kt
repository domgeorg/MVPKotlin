package gr.mobile.mvp.kotlin.network.response.article

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleResponse(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("subtitle")
    var subtitle: String? = null,

    @SerializedName("summary")
    var summary: String? = null,

    @SerializedName("date")
    var date: String? = null,

    @SerializedName("photo")
    var photo: String? = null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("caption")
    var caption: String? = null,

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("public_url")
    var public_url: String? = null,

    @SerializedName("timestamp")
    var timestamp: Long? = null,

    @SerializedName("date_modified")
    var date_modified: String? = null,

    @SerializedName("modified_timestamp")
    var modified_timestamp: Long? = null,

    @SerializedName("comments_total")
    var comments_total: Int? = null,

    @SerializedName("video")
    var video: String? = null,

    @SerializedName("web_view_url")
    var webViewUrl: String? = null

) : Parcelable
