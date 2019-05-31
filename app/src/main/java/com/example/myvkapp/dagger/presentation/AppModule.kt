package com.example.myvkapp.dagger.presentation

import com.example.myvkapp.dagger.ActivityScope
import com.example.myvkapp.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun provideMainActivity() : MainActivity
}