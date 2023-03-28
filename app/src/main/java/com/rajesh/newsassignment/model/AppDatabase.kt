package com.rajesh.newsassignment.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rajesh.newsassignment.model.dao.ArticleDao

@Database(entities = [ArticleTable::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val articleDao : ArticleDao
}