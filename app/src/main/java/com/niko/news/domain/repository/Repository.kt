package com.niko.news.domain.repository

import com.niko.news.domain.models.dataModels.GetArticleDataModel
import com.niko.news.domain.models.entities.ArticleModel
import io.reactivex.Observable

interface Repository {
    fun removeAllArticles(): Observable<Boolean>
    fun saveArticles(articles: List<ArticleModel>): Observable<Boolean>
    fun selectArticlesByCategory(category: String): Observable<List<ArticleModel>>
    fun getArticles(getArticleDataModel: GetArticleDataModel): Observable<List<ArticleModel>>
}