package com.niko.news.ui.main.news

import com.arellomobile.mvp.InjectViewState
import com.niko.news.domain.models.dataModels.GetNewsDataModel
import com.niko.news.domain.useCases.GetNewsUseCase
import com.niko.news.other.async
import com.niko.news.other.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class NewsPresenter
@Inject
constructor(
        private val getNewsUseCase: GetNewsUseCase
) : BasePresenter<NewsView>() {
    init {
        getNewsUseCase.createObservable(
                GetNewsDataModel(category = "business", page = 1)
        ).async().subscribe({
            println(it)
        }, {
            println(it)
        }).tracked()
    }
}