package gr.mobile.mvp.kotlin.network.parser.response.articleLeads

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleLeadsResponse(
     val carousel: List<Article>?=null,

    val life: List<Article>?=null,

    val main: List<Article>?=null,

   val sports: List<Article>?=null
) : Parcelable