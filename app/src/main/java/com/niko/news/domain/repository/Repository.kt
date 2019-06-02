package com.niko.news.domain.repository

import com.niko.news.domain.models.dataModels.GetNewsDataModel
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response

interface Repository {
    fun getNews(getNewsDataModel: GetNewsDataModel): Observable<Response<ResponseBody>>
}