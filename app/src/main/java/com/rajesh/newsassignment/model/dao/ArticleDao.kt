package com.rajesh.newsassignment.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rajesh.newsassignment.model.ArticleTable

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun findAll(): LiveData<List<ArticleTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<ArticleTable>)
}