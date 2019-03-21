package gr.mobile.mvp.kotlin.ui.adapter.articles

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.network.parser.response.articleLeads.Article
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_article.*

class ArticlesRecyclerViewAdapter(private val sportArticles: List<Article>) :
    RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticlesRecyclerViewAdapter.ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_article,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = sportArticles.size

    override fun onBindViewHolder(articleViewHolder: ArticleViewHolder, position: Int) {
        articleViewHolder.bind(sportArticles[position])
    }

    class ArticleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(article: Article) {
            Picasso.get().load(article.photo).into(photoImageView)
            titleTextView.text = article.title
            subtitleTextView.text = article.subtitle
        }
    }
}