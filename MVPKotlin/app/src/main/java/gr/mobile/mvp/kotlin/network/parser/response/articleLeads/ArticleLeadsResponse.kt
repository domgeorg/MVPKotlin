package gr.mobile.mvp.kotlin.network.parser.response.articleLeads

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleLeadsResponse(
    @SerializedName("carousel")
     var carousel: List<Article>?=null,

    @SerializedName("life")
    var life: List<Article>?=null,

    @SerializedName("main")
    var main: List<Article>?=null,

    @SerializedName("sports")
   var sports: List<Article>?=null
) : Parcelable