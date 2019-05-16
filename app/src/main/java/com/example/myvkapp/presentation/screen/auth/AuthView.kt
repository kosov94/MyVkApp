package com.example.myvkapp.presentation.screen.auth

import com.arellomobile.mvp.MvpView

interface AuthView: MvpView{
    fun showToast(message: String)
}