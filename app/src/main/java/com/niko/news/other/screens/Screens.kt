package com.niko.news.other.screens

import androidx.fragment.app.Fragment
import com.niko.news.ui.main.news.NewsFragment
import com.niko.news.ui.main.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class SplashScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SplashFragment.newInstance()
        }
    }

    class NewsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return NewsFragment()
        }
    }

}