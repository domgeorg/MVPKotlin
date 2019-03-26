package gr.mobile.mvp.kotlin.ui.activity.articleDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.view.View
import com.squareup.picasso.Picasso
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.common.Definitions
import gr.mobile.mvp.kotlin.common.extensions.dateFormatted
import gr.mobile.mvp.kotlin.model.article.ArticleWrapper
import gr.mobile.mvp.kotlin.mvp.presenter.articleDetails.ArticleDetailsMvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.articleDetails.ArticleDetailsMvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_article_details.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ArticleDetailsActivity : BaseActivity<ArticleDetailsMvpPresenter>(), ArticleDetailsMvpView {

    private lateinit var articleWrapper: ArticleWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        getPassData()
        initLayout()
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(0, R.anim.abc_fade_out)
    }

    @SuppressLint("SetTextI18n")
    private fun initLayout() {
        backImageView.visibility = View.INVISIBLE
        closeImageView.visibility = View.VISIBLE
        closeImageView.setOnClickListener { onBackPressed() }
        Picasso.get().load(articleWrapper.article?.photo).into(photoImageView)
        categoryTextView.text = articleWrapper.header + ": "
        dateTextView.text = dateFormatted(articleWrapper.article?.timestamp?.times(1000), Definitions.ARTICLE_DETAILS_DATE)
        titleTextView.text =articleWrapper.article?.title
        articleWrapper.article?.subtitle.isNullOrEmpty().let { if (it) subtitleTextView.visibility = View.GONE }
        subtitleTextView.text = articleWrapper.article?.subtitle
        contentTextView.text = Html.fromHtml(articleWrapper.article?.content).toString()
    }

    private fun getPassData() {
        articleWrapper = intent.extras?.getParcelable(getString(R.string.article_details_bundle)) as ArticleWrapper
    }
}
