package com.example.myvkapp.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.myvkapp.presentation.common.BasePresenter
import com.example.myvkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class SplashPresenter  @Inject constructor(private val router: Router) : BasePresenter<SplashView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(Screen.ProfileViewScreen())
        }, 2000)
    }
    //TODO(timer, AuthScreen)

}
