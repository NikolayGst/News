package com.niko.news.app.modules

import com.niko.news.other.annotations.PerActivity
import com.niko.news.ui.main.MainActivity
import com.niko.news.ui.main.MainFragmentsBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(
            modules = [MainFragmentsBindingModule::class]
    )
    abstract fun bindMainActivity(): MainActivity

}