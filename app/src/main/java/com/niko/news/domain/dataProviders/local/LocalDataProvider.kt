package com.niko.news.domain.dataProviders.local

import com.niko.news.domain.models.entities.ArticleModel
import io.reactivex.Observable

interface LocalDataProvider {
    fun removeAllArticles(): Observable<Boolean>
    fun saveArticles(articles: List<ArticleModel>): Observable<Boolean>
    fun selectArticlesByCategory(category: String): Observable<List<ArticleModel>>
}