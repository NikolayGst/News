package com.niko.news.ui.main.news

import com.arellomobile.mvp.InjectViewState
import com.niko.news.domain.useCases.SelectArticlesByCategoryUseCase
import com.niko.news.domain.useCases.SelectCountsByCategoryUseCase
import com.niko.news.other.async
import com.niko.news.other.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class NewsPresenter
@Inject
constructor(
        selectCountsByCategoryUseCase: SelectCountsByCategoryUseCase,
        private val selectArticlesByCategoryUseCase: SelectArticlesByCategoryUseCase
) : BasePresenter<NewsView>() {

    init {
        selectCountsByCategoryUseCase.createObservable()
                .async()
                .subscribeBy(
                        onNext = { viewState.onSuccessGetCounts(it) },
                        onError = { viewState.onFailure(it) })
                .tracked()
    }

    fun getNewsByParam(category: String) {
        selectArticlesByCategoryUseCase.createObservable(category)
                .take(1)
                .async()
                .subscribeBy(
                        onNext = { viewState.onSuccessGetArticlesByCategory(it) },
                        onError = { viewState.onFailure(it) }
                ).tracked()
    }

}