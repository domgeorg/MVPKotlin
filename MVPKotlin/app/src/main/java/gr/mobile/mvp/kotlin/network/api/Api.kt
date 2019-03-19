package gr.mobile.mvp.kotlin.network.api

import gr.mobile.mvp.kotlin.common.Definitions
import gr.mobile.mvp.kotlin.network.response.categories.CategoriesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET(Definitions.URL_CATEGORIES)
    fun getCategories(): Observable<CategoriesResponse>
}