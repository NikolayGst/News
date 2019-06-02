package com.niko.news.ui.main

import android.os.Bundle
import com.niko.news.R
import com.niko.news.other.annotations.LayoutResourceId
import com.niko.news.other.base.BaseActivity
import com.niko.news.other.screens.Screens
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@LayoutResourceId(R.layout.activity_main)
class MainActivity : BaseActivity(){

    private val navigator: SupportAppNavigator = SupportAppNavigator(this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router


    override fun renderView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            router.newRootChain(Screens.SplashScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

}
