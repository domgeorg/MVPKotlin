package gr.mobile.mvp.kotlin.mvp.presenter.articles

import gr.mobile.mvp.kotlin.model.article.ArticleWrapper
import gr.mobile.mvp.kotlin.mvp.interactor.articles.ArticlesMvpInteractor
import gr.mobile.mvp.kotlin.mvp.presenter.base.MvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.articles.ArticlesMvpView

class ArticlesMvpPresenterImpl(
    view: ArticlesMvpView,
    interactor: ArticlesMvpInteractor
) : MvpPresenterImpl<ArticlesMvpView, ArticlesMvpInteractor>(view, interactor), ArticlesMvpPresenter {

    private var articleList: MutableList<ArticleWrapper> = ArrayList()

    override fun getArticles() {
        if (!isViewAttached()) {
            return
        }
        getView()?.showLoading()
        getInteractor()?.getArticles({ articleLeadsResponse ->

            if (articleLeadsResponse.carousel != null && !articleLeadsResponse.carousel.isEmpty()) {
                val header = ArticleWrapper(null, true, "Carousel", articleList.isEmpty(), false)
                articleList.add(header)
                for (i in articleLeadsResponse.carousel.indices) {
                    val article = ArticleWrapper(articleLeadsResponse.carousel[i], false, "Carousel", false, false)
                    articleList.add(article)
                }
            }

            if (articleLeadsResponse.main != null && !articleLeadsResponse.main.isEmpty()) {
                val header = ArticleWrapper(null, true, "Main", articleList.isEmpty(), false)
                articleList.add(header)
                for (i in articleLeadsResponse.main.indices) {
                    val article = ArticleWrapper(articleLeadsResponse.main[i], false, "Main", false, false)
                    articleList.add(article)
                }
            }

            if (articleLeadsResponse.sports != null && !articleLeadsResponse.sports.isEmpty()) {
                val header = ArticleWrapper(null, true, "Sports", articleList.isEmpty(), false)
                articleList.add(header)
                for (i in articleLeadsResponse.sports.indices) {
                    val article = ArticleWrapper(articleLeadsResponse.sports[i], false, "Sports", false, false)
                    articleList.add(article)
                }
            }

            if (articleLeadsResponse.life != null && !articleLeadsResponse.life.isEmpty()) {
                val header = ArticleWrapper(null, true, "Life", articleList.isEmpty(), false)
                articleList.add(header)
                for (i in articleLeadsResponse.life.indices) {
                    val article = ArticleWrapper(articleLeadsResponse.life[i], false, "Life", false, false)
                    articleList.add(article)
                }

                if (articleList.isEmpty()) {
                    getView()?.showEmpty()
                } else {
                    articleList[articleList.size-1].isLastItem = true
                    getView()?.showArticles(articleList)
                }
            }
        }, { throwable -> getView()?.showError(throwable.localizedMessage) }
        )
    }
}
