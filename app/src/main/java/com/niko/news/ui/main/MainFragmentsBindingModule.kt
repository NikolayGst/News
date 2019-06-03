package com.niko.news.ui.main

import com.niko.news.other.annotations.PerFragment
import com.niko.news.ui.main.news.NewsFragment
import com.niko.news.ui.main.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindSplashFragment(): SplashFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindNewsFragment(): NewsFragment
}