package com.rajesh.newsassignment

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rajesh.newsassignment.adapter.ArticleAdapter
import com.rajesh.newsassignment.model.entity.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top_news_layout.*


class DetailsActivity : AppCompatActivity() {

    lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val articleList: ArrayList<Article> = this.intent.extras.getSerializable("ListExtra") as ArrayList<Article>
        val article : Article = this.intent.extras.getSerializable("objectExtra") as Article

        articleAdapter = ArticleAdapter()
        recyclerview.adapter = articleAdapter
        updateUI(article)
        articleAdapter.setItems(articleList.subList(1,articleList.size))
    }

    private fun updateUI(first: Article) {
        top_news_title.text = first.title
        top_news_desc.text = first.description
        top_news_source.text = first.source.name
        Picasso.get().load(first.urlToImage).into(top_news_image)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
