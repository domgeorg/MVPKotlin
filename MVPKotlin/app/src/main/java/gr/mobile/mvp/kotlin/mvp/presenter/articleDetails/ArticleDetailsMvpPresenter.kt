package gr.mobile.mvp.kotlin.mvp.presenter.articleDetails

import gr.mobile.mvp.kotlin.mvp.interactor.articleDetails.ArticleDetailsMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.articleDetails.ArticleDetailsMvpView

interface ArticleDetailsMvpPresenter : MvpPresenter<ArticleDetailsMvpView, ArticleDetailsMvpInteractor> {
}