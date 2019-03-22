package gr.mobile.mvp.kotlin.mvp.presenter.articles

import gr.mobile.mvp.kotlin.mvp.interactor.articles.ArticlesMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.articles.ArticlesMvpView

interface ArticlesMvpPresenter : MvpPresenter<ArticlesMvpView, ArticlesMvpInteractor> {

    fun getArticles()
}