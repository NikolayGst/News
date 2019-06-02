package com.niko.news.ui.main.splash

import com.arellomobile.mvp.InjectViewState
import com.niko.news.domain.useCases.GetAllArticlesUseCase
import com.niko.news.other.async
import com.niko.news.other.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class SplashPresenter
@Inject
constructor(getAllArticlesUseCase: GetAllArticlesUseCase)
    : BasePresenter<SplashView>() {
    init {
        getAllArticlesUseCase.createObservable()
                .async()
                .subscribeBy(onNext = {
                    viewState.onSuccessUpdateArticles()
                }, onError = {
                    viewState.onFailure(it)
                })
                .tracked()
    }
}