package com.niko.news.ui.main.news

import com.arellomobile.mvp.InjectViewState
import com.niko.news.domain.useCases.SelectArticlesByCategoryUseCase
import com.niko.news.other.async
import com.niko.news.other.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class NewsPresenter
@Inject
constructor(
        private val selectArticlesByCategoryUseCase: SelectArticlesByCategoryUseCase
) : BasePresenter<NewsView>() {

    fun getNewsByParam(category: String) {
        selectArticlesByCategoryUseCase.createObservable(category)
                .async()
                .subscribe({
                    println(it)
                }, {
                    println(it)
                }).tracked()
    }

}