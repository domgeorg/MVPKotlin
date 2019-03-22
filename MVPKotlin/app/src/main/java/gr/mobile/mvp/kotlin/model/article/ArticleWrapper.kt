package gr.mobile.mvp.kotlin.model.article

import android.os.Parcelable
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.Article
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleWrapper(
    var article: Article?,
    var isHeader: Boolean,
    var header: String,
    var isFirstItem: Boolean,
    var isLastItem: Boolean
) : Parcelable