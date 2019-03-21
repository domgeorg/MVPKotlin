package gr.mobile.mvp.kotlin.mvp.presenter.articles

import gr.mobile.mvp.kotlin.mvp.interactor.articles.ArticlesMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.articles.ArticlesMvpView

class ArticlesMvpPresenterImpl(
        view: ArticlesMvpView,
        interactor: ArticlesMvpInteractor
) : MvpPresenterImpl<ArticlesMvpView, ArticlesMvpInteractor>(view, interactor), ArticlesMvpPresenter {

    override fun getMainArticles() {
        if (!isViewAttached()) {
            return
        }
        getView()?.showLoading()
        getInteractor()?.getMainArticles({ articleList ->
            if (articleList.isEmpty()) {
                getView()?.showEmpty()
            } else {
                getView()?.showMainArticles(articleList)
            }
        }, { throwable -> getView()?.showError(throwable.localizedMessage) }
        )
    }
}
