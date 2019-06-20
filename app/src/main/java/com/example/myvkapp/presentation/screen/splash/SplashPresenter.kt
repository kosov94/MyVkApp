package com.example.myvkapp.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.myvkapp.domain.repository.SessionRepository
import com.example.myvkapp.presentation.common.BasePresenter
import com.example.myvkapp.presentation.navigation.Screen
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@InjectViewState
class SplashPresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository
) : BasePresenter<SplashView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Completable.timer(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                router.newRootScreen(
                    if (sessionRepository.isAuth()) {
                        Screen.ProfileViewScreen()
                    } else {
                        Screen.AuthViewScreen()
                    }
                )
            }, {})
    }
}
