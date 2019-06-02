package com.niko.news.ui.main.splash

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface SplashView: MvpView {
    fun onSuccessUpdateArticles()
    fun onFailure(throwable: Throwable)
}