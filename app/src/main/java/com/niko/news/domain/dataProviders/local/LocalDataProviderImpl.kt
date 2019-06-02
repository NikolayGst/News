package com.niko.news.domain.dataProviders.local

import android.content.SharedPreferences
import com.niko.news.domain.dataProviders.local.database.Database
import com.niko.news.domain.models.entities.ArticleModel
import io.reactivex.Observable

class LocalDataProviderImpl(
        private val sharedPreferences: SharedPreferences,
        private val database: Database
) : LocalDataProvider {

    override fun removeAllArticles(): Observable<Boolean> {
        return Observable.fromCallable {
            database.getArticlesDao().deleteArticles()
        }.map {
            true
        }
    }

    override fun saveArticles(articles: List<ArticleModel>): Observable<Boolean> {
        return Observable.fromCallable {
            database.getArticlesDao().insertArticles(articles)
        }.map {
            true
        }
    }

    override fun selectArticlesByCategory(category: String): Observable<List<ArticleModel>> {
        return database.getArticlesDao().selectArticlesByCategory(category).toObservable()
    }
}