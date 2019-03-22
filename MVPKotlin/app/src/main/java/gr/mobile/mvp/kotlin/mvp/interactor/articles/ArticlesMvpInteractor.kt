package gr.mobile.mvp.kotlin.mvp.interactor.articles

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.ArticleLeadsResponse

interface ArticlesMvpInteractor : MvpInteractor {

    fun getArticles(successCallback: (ArticleLeadsResponse) -> Unit, errorCallback: (Throwable) -> Unit)
}