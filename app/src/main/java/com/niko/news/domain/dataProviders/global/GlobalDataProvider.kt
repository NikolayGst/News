package com.niko.news.domain.dataProviders.global

import com.niko.news.domain.models.responseModels.ArticlesWrapperModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GlobalDataProvider {
    @GET("top-headlines")
    fun getArticles(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("page") page: Int,
            @Query("pageSize") pageSize: Int,
            @Query("apiKey") apiKey: String
    ): Observable<ArticlesWrapperModel>
}