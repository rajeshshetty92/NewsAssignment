package com.rajesh.newsassignment.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rajesh.newsassignment.model.Source
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "article")
data class ArticleTable(
        @PrimaryKey val id: Long,
        val author: String?,
        val content: String?,
        val description: String?,
        val publishedAt: String?,
        val title: String?,
        val url: String?,
        val urlToImage: String?
)