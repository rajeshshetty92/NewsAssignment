package com.rajesh.newsassignment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.rajesh.newsassignment.adapter.ArticleAdapter
import com.rajesh.newsassignment.model.entity.Article
import com.rajesh.newsassignment.utils.LoadingState
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.rajesh.newsassignment.viewmodel.ArticleViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top_news_layout.*


class MainActivity : AppCompatActivity() {

    private lateinit var articleAdapter: ArticleAdapter
    private val articleViewModel by viewModel<ArticleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        articleAdapter = ArticleAdapter()
        recyclerview.adapter = articleAdapter

        articleViewModel.data.observe(this, Observer {
            it?.let {
                updateUI(it.first())
                articleAdapter.setItems(it.subList(1,it.size))
            }
        })

        articleViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
        articleViewModel.fetchData("in","f3940492dfaf486d9f135799f3965323")
    }

    private fun updateUI(first: Article) {
        top_news_title.text = first.title
        top_news_desc.text = first.description
        top_news_source.text = first.source.name
        Picasso.get().load(first.urlToImage).into(top_news_image)
    }
}
