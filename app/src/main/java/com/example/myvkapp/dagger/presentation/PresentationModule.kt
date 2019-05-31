package com.example.myvkapp.dagger.presentation

import dagger.Module

@Module(
    includes = [
        AppModule::class,
        MainActivityModule::class,
        NavigationModule::class]
)
interface PresentationModule