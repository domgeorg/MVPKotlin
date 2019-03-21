package gr.mobile.mvp.kotlin.mvp.interactor.articles

import gr.mobile.mvp.kotlin.mvp.interactor.base.MvpInteractorImpl
import gr.mobile.mvp.kotlin.network.client.Client
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArticlesMvpInteractorImpl(private val client: Client) : MvpInteractorImpl(), ArticlesMvpInteractor {

    override fun getMainArticles(successCallback: (List<Article>) -> Unit, errorCallback: (Throwable) -> Unit) {
        makeRequest(client.getArticles()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(
                    { articleLeadsResponse -> articleLeadsResponse?.main?.let { successCallback.invoke(it) } },
                    { throwable -> errorCallback.invoke(throwable) }
                ))
    }
}