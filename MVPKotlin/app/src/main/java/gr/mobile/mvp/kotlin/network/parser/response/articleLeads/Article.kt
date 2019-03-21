package gr.mobile.mvp.kotlin.network.parser.response.articleLeads

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    var id: Int? = null,

    var title: String? = null,

    var subtitle: String? = null,

    var summary: String? = null,

    var date: String? = null,

    var photo: String? = null,

    var content: String? = null,

    var caption: String? = null,

    var author: String? = null,

    var public_url: String? = null,

    var timestamp: Long? = null,

    var date_modified: String? = null,

    var modified_timestamp: Long? = null,

    var comments_total: Int? = null,

    var video: String? = null,

    var web_view_url: String? = null
) : Parcelable