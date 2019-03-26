package gr.mobile.mvp.kotlin.ui.activity.articles

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.article.ArticleWrapper
import gr.mobile.mvp.kotlin.mvp.interactor.articles.ArticlesMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.articles.ArticlesMvpPresenter
import gr.mobile.mvp.kotlin.mvp.presenter.articles.ArticlesMvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.articles.ArticlesMvpView
import gr.mobile.mvp.kotlin.network.client.Client
import gr.mobile.mvp.kotlin.ui.activity.articleDetails.ArticleDetailsActivity
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import gr.mobile.mvp.kotlin.ui.adapter.articles.ArticlesRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_articles.*
import kotlinx.android.synthetic.main.layout_empty.*
import kotlinx.android.synthetic.main.layout_loading.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ArticlesActivity : BaseActivity<ArticlesMvpPresenter>(), ArticlesMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        presenter = ArticlesMvpPresenterImpl(this, ArticlesMvpInteractorImpl(Client().createApi()))
        initLayout()
        presenter?.getArticles()
    }

    override fun showLoading() {
        loadingView.visibility = View.VISIBLE
        emptyView.visibility = View.GONE
    }

    override fun showEmpty() {
        emptyView.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
    }

    override fun showError(error: String) {
        emptyView.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
        emptyTextView.text = error
    }

    override fun showGenericError() {
        super.showGenericError()
        showEmpty()
    }

    override fun showArticles(articles: List<ArticleWrapper>) {
        loadingView.visibility = View.GONE
        emptyView.visibility = View.GONE
        articlesRecyclerView.layoutManager = LinearLayoutManager(this)
        articlesRecyclerView.adapter = ArticlesRecyclerViewAdapter(articles) { articleWrapper, photoImageView, titleTextView, subtitleTextView ->
            run {
                val intent = Intent(this@ArticlesActivity, ArticleDetailsActivity::class.java)
                intent.putExtra(getString(R.string.article_details_bundle), articleWrapper)

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    val photoImageViewPair = Pair.create<View, String>(photoImageView, getString(R.string.transition_article_photo))
                    val titleTextViewPair = Pair.create<View, String>(titleTextView, getString(R.string.transition_article_title))
                    val subtitleTextViewPair = Pair.create<View, String>(subtitleTextView, getString(R.string.transition_article_subtitle))
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@ArticlesActivity, photoImageViewPair, titleTextViewPair, subtitleTextViewPair)
                    startActivity(intent, options.toBundle())
                } else {
                    startActivityModal(intent)
                }
            }
        }
    }

    private fun initLayout() {
        titleToolbarTextView.text = getText(R.string.articles)
        backImageView.setOnClickListener {
            finish()
            overridePendingTransition(0, R.anim.anim_slide_down)
        }
    }
}