package gr.mobile.mvp.kotlin.network.api

import gr.mobile.mvp.kotlin.common.Definitions
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.ArticleLeadsResponse
import gr.mobile.mvp.kotlin.network.parser.response.categories.CategoriesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET(Definitions.URL_CATEGORIES)
    fun getCategories(): Observable<CategoriesResponse>

    @GET(Definitions.URL_LEAD)
    fun getArticles(): Observable<ArticleLeadsResponse>
}