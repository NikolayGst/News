package com.niko.news.domain.dataProviders.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.niko.news.domain.dataProviders.local.database.daos.ArticlesDao
import com.niko.news.domain.models.entities.ArticleModel

@Database(
        entities = [
            ArticleModel::class
        ],
        version = 1,
        exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun getArticlesDao(): ArticlesDao
}