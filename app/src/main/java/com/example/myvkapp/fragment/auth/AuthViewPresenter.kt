package com.example.myvkapp.fragment.auth

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.App
import com.example.myvkapp.navigation.Screen

@InjectViewState
class AuthViewPresenter: MvpPresenter<AuthView>() {
    fun signInClick(login: String, password: String) {
        if(login=="admin"&&password=="123")
            App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
        else
            viewState.showToast("Incorrect login or password")
    }

}