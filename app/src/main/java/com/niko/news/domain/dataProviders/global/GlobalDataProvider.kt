package com.niko.news.domain.dataProviders.global

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GlobalDataProvider {
    @GET("top-headlines")
    fun getNews(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("page") page: Int,
            @Query("apiKey") apiKey: String
    ): Observable<Response<ResponseBody>>
}