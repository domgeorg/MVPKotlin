package gr.mobile.mvp.kotlin.ui.adapter.articles

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.article.ArticleWrapper
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_article.*

class ArticlesRecyclerViewAdapter(
    private val articles: List<ArticleWrapper>,
    private val onArticleClick: (ArticleWrapper, photoImageView: AppCompatImageView, titleTextView: AppCompatTextView, subtitleTextView: AppCompatTextView) -> Unit
) : RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_article, parent, false))
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(articleViewHolder: ArticleViewHolder, position: Int) =
        articleViewHolder.bind(articles[position], onArticleClick)

    class ArticleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(
            articleWrapper: ArticleWrapper,
            onArticleClick: (ArticleWrapper, photoImageView: AppCompatImageView, titleTextView: AppCompatTextView, subtitleTextView: AppCompatTextView) -> Unit
        ) {
            bottomSpace?.visibility = if (articleWrapper.isLastItem) View.VISIBLE else View.GONE
            headerTextView?.visibility = if (articleWrapper.isHeader) View.VISIBLE else View.GONE
            articleCardView?.visibility = if (articleWrapper.isHeader) View.GONE else View.VISIBLE
            headerTextView?.text = articleWrapper.header
            Picasso.get().load(articleWrapper.article?.photo).error(R.drawable.splash).into(photoImageView)
            titleTextView?.text = articleWrapper.article?.title
            subtitleTextView?.text = articleWrapper.article?.subtitle
            containerView.setOnClickListener {
                onArticleClick(
                    articleWrapper,
                    photoImageView,
                    titleTextView,
                    subtitleTextView
                )
            }
        }
    }
}