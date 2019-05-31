package com.example.myvkapp.dagger

import com.example.myvkapp.App
import com.example.myvkapp.dagger.data.DataModule
import com.example.myvkapp.dagger.presentation.PresentationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        PresentationModule::class,
        DataModule::class
    ])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<App>

}