package gr.mobile.mvp.kotlin.mvp.presenter.articleDetails

import gr.mobile.mvp.kotlin.mvp.interactor.articleDetails.ArticleDetailsMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.articleDetails.ArticleDetailsMvpView

class ArticleDetailsMvpPresenterImpl(
        view: ArticleDetailsMvpView,
        interactor: ArticleDetailsMvpInteractor
) : MvpPresenterImpl<ArticleDetailsMvpView, ArticleDetailsMvpInteractor>(view, interactor), ArticleDetailsMvpPresenter {

}