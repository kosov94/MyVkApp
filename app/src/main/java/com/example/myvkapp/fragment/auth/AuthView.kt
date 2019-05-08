package com.example.myvkapp.fragment.auth

import com.arellomobile.mvp.MvpView

interface AuthView: MvpView{
    fun showToast(message: String)
}