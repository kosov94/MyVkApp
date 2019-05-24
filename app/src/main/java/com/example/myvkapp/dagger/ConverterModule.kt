package com.example.myvkapp.dagger

import com.example.myvkapp.data.converter.Converter
import com.example.myvkapp.data.converter.UserConverter
import com.example.myvkapp.data.response.ProfileResponse
import com.example.myvkapp.domain.entity.User
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): Converter<ProfileResponse, User>
}