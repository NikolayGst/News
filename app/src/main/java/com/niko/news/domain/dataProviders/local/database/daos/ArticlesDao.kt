package com.niko.news.domain.dataProviders.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.niko.news.domain.models.entities.ArticleModel
import io.reactivex.Flowable

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<ArticleModel>)

    @Query("DELETE FROM articles")
    fun deleteArticles()

    @Query("SELECT * from articles WHERE category = :category")
    fun selectArticlesByCategory(category: String): Flowable<List<ArticleModel>>

}