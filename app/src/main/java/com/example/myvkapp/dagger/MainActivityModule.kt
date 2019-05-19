package com.example.myvkapp.dagger

import com.example.myvkapp.presentation.screen.auth.AuthViewFragment
import com.example.myvkapp.presentation.screen.profile.ProfileViewFragment
import com.example.myvkapp.presentation.screen.profileEdit.ProfileEditViewFragment
import com.example.myvkapp.presentation.screen.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideAuthViewFragment(): AuthViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileViewFragment(): ProfileViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileEditViewFragment(): ProfileEditViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashFragment(): SplashFragment
}