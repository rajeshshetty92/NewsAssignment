package com.rajesh.newsassignment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajesh.newsassignment.DetailsActivity
import com.rajesh.newsassignment.R
import com.rajesh.newsassignment.model.entity.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.other_news_layout.view.*


class ArticleAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var articleList = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.other_news_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = articleList[position]
        holder.bind(user, articleList as ArrayList<Article>)
    }

    fun setItems(it: List<Article>) {
        this.articleList = it.toMutableList()
        notifyDataSetChanged()
    }

}

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title: TextView = view.top_news_title
    private val desc: TextView = view.top_news_desc
    private val image: ImageView = view.top_news_image
    private val source: TextView = view.top_news_source
    private val root : View = view.root

    fun bind(article: Article, articleList: ArrayList<Article>) {
        title.text = article.title
        desc.text = article.description
        source.text = article.source.name
        Picasso.get().load(article.urlToImage).into(image)

        root.setOnClickListener {
            val intent = Intent(root.context, DetailsActivity::class.java)
            intent.apply {
                putExtra("ListExtra", articleList)
                putExtra("objectExtra", article)
            }
            root.context.startActivity(intent)
        }
    }

}
