package gr.mobile.mvp.kotlin.mvp.view.articles

import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.Article

interface ArticlesMvpView : MvpView {

    fun showMainArticles(sportArticles: List<Article>)

}