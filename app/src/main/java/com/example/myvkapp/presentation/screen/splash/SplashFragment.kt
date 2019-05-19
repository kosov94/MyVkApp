package com.example.myvkapp.presentation.screen.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseFragment
import javax.inject.Inject

class SplashFragment: BaseFragment(R.layout.fragment_splash), SplashView {

    @Inject
    @InjectPresenter
    lateinit var presenter : SplashPresenter

    @ProvidePresenter
    fun providePresener(): SplashPresenter = presenter
}