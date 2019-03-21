package gr.mobile.mvp.kotlin.mvp.interactor.articles

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractor
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.Article

interface ArticlesMvpInteractor : MvpInteractor {

    fun getMainArticles(successCallback: (List<Article>) -> Unit, errorCallback: (Throwable) -> Unit)
}