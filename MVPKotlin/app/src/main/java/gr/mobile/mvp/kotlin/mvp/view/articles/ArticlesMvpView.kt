package gr.mobile.mvp.kotlin.mvp.view.articles

import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.model.article.ArticleWrapper

interface ArticlesMvpView : MvpView {

    fun showArticles(articles: List<ArticleWrapper>)

}