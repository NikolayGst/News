package com.niko.news.ui.main.splash


import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.niko.news.R
import com.niko.news.other.annotations.LayoutResourceId
import com.niko.news.other.base.BaseFragment
import com.niko.news.other.screens.Screens
import com.niko.news.other.showThrowableMessage
import ru.terrakok.cicerone.Router
import javax.inject.Inject

const val SPLASH_SCENE_DURATION = 3500L

@LayoutResourceId(R.layout.fragment_splash)
class SplashFragment : BaseFragment(), SplashView {

    @Inject
    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    fun provideSplashPresenter() = splashPresenter

    @Inject
    lateinit var router: Router

    override fun renderView(view: View, savedInstanceState: Bundle?) {

    }

    override fun onSuccessUpdateArticles() {
        router.newRootScreen(Screens.NewsScreen())
    }

    override fun onFailure(throwable: Throwable) {
        showThrowableMessage(throwable)
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }
}
