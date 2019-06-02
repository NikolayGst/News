package com.niko.news.domain.repository

import com.niko.news.domain.dataProviders.global.GlobalDataProvider
import com.niko.news.domain.dataProviders.local.LocalDataProvider
import com.niko.news.domain.models.dataModels.GetNewsDataModel
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response

class RepositoryImpl(
        private val apiKey: String,
        private val globalDataProvider: GlobalDataProvider,
        private val localDataProvider: LocalDataProvider
) : Repository {
    override fun getNews(getNewsDataModel: GetNewsDataModel): Observable<Response<ResponseBody>> {
        return globalDataProvider.getNews(
                getNewsDataModel.country,
                getNewsDataModel.category,
                getNewsDataModel.page,
                apiKey
        )
    }
}