package com.example.myvkapp.presentation.screen.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.App
import com.example.myvkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router

@InjectViewState
class AuthViewPresenter(private val router: Router): MvpPresenter<AuthView>() {
    fun signInClick(login: String, password: String) {
        if(login=="admin"&&password=="123")
            router.newRootScreen(Screen.ProfileViewScreen())
        else
            viewState.showToast("Incorrect login or password")
    }

}