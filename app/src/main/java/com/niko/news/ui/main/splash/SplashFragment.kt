package com.niko.news.ui.main.splash


import android.os.Bundle
import android.os.Handler
import android.view.View
import com.niko.news.R
import com.niko.news.other.annotations.LayoutResourceId
import com.niko.news.other.base.BaseFragment
import com.niko.news.other.screens.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

const val SPLASH_SCENE_DURATION = 3500L

@LayoutResourceId(R.layout.fragment_splash)
class SplashFragment : BaseFragment() {

    @Inject
    lateinit var router: Router

    override fun renderView(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({
            router.navigateTo(Screens.NewsScreen())
        }, SPLASH_SCENE_DURATION)
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }
}
