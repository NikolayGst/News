package com.niko.news.domain.repository

import com.niko.news.domain.dataProviders.global.GlobalDataProvider
import com.niko.news.domain.dataProviders.local.LocalDataProvider
import com.niko.news.domain.models.dataModels.GetArticleDataModel
import com.niko.news.domain.models.entities.ArticleModel
import io.reactivex.Observable

class RepositoryImpl(
        private val apiKey: String,
        private val globalDataProvider: GlobalDataProvider,
        private val localDataProvider: LocalDataProvider
) : Repository {

    override fun removeAllArticles(): Observable<Boolean> {
        return localDataProvider.removeAllArticles()
    }

    override fun saveArticles(articles: List<ArticleModel>): Observable<Boolean> {
        return localDataProvider.saveArticles(articles)
    }

    override fun selectArticlesByCategory(category: String): Observable<List<ArticleModel>> {
        return localDataProvider.selectArticlesByCategory(category)
    }

    override fun getArticles(getArticleDataModel: GetArticleDataModel): Observable<List<ArticleModel>> {
        return globalDataProvider.getArticles(
                getArticleDataModel.country,
                getArticleDataModel.category,
                getArticleDataModel.page,
                getArticleDataModel.pageSize,
                apiKey
        ).map { list ->
            list.articles.filter {
                !it.description.isNullOrEmpty() && !it.urlToImage.isNullOrEmpty()
            }
        }.map { list ->
            list.map { it.copy(category = getArticleDataModel.category) }
        }
    }
}