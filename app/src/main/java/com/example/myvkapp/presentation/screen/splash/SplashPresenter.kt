package com.example.myvkapp.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.myvkapp.domain.repository.SessionRepository
import com.example.myvkapp.presentation.common.BasePresenter
import com.example.myvkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class SplashPresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository
) : BasePresenter<SplashView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(
                if (sessionRepository.isAuth()) {
                    Screen.ProfileViewScreen()
                } else {
                    Screen.AuthViewScreen()
                }
            )
        }, 2000)

    }
}
