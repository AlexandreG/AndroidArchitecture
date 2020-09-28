package fr.zzi.androidarchitecture.feature.articlelist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.articlelist.domain.Article
import fr.zzi.androidarchitecture.feature.articlelist.ui.ArticleListAdapter.ArticleViewHolder

class ArticleListAdapter(private val context: Context) : RecyclerView.Adapter<ArticleViewHolder>() {

    interface Listener {
        fun onItemClick(article: Article)
    }

    var data: List<Article> = emptyList()
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_article_item, parent, false)
        return ArticleViewHolder(item)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentItem = data.get(position)
        holder.title.text = currentItem.titre
        if (currentItem.link.isNullOrEmpty()) {
            holder.description.text = "Article non disponible"
            holder.itemView.setOnClickListener(null)
        } else {
            holder.itemView.setOnClickListener {
                listener?.onItemClick(currentItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.article_item_date)
        val image: ImageView = view.findViewById(R.id.article_item_image)
        val title: TextView = view.findViewById(R.id.article_item_title)
        val description: TextView = view.findViewById(R.id.article_item_description)

    }
}