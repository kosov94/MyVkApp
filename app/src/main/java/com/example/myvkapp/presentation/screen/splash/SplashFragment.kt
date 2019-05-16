package com.example.myvkapp.presentation.screen.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseFragment

class SplashFragment: BaseFragment(R.layout.fragment_splash), SpalshView {

    @InjectPresenter
    lateinit var presenter : SplashPresenter
}