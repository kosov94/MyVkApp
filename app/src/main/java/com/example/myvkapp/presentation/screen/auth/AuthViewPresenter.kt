package com.example.myvkapp.presentation.screen.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.App
import com.example.myvkapp.domain.repository.SessionRepository
import com.example.myvkapp.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class AuthViewPresenter @Inject constructor(
        private val sessionRepository: SessionRepository,
        private val router: Router
) : MvpPresenter<AuthView>() {

    fun signInClick(login: String, password: String) {

        sessionRepository
                .login(login, password)
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    router.newRootScreen(Screen.ProfileViewScreen())
                },
                        {
                            // viewState.showToast("Incorrect login or password")
                            router.newRootScreen(Screen.ProfileViewScreen())
                        })
    }

}