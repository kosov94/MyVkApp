package com.example.myvkapp.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.App
import com.example.myvkapp.presentation.navigation.Screen


@InjectViewState
class SplashPresenter : MvpPresenter<SpalshView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
        }, 1500)
    }
    //TODO(timer, AuthScreen)

}
