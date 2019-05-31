package com.example.myvkapp.dagger.data

import com.example.myvkapp.data.converter.DataConverter
import com.example.myvkapp.data.converter.PostsConverter
import com.example.myvkapp.data.converter.UserConverter
import com.example.myvkapp.data.response.PostsResponse
import com.example.myvkapp.data.response.ProfileResponse
import com.example.myvkapp.domain.entity.PostEntity
import com.example.myvkapp.domain.entity.UserEntity
import com.example.myvkapp.presentation.converter.Converter
import com.example.myvkapp.presentation.converter.FeedPostConvertor
import com.example.myvkapp.presentation.converter.ProfileConvert
import com.example.myvkapp.presentation.model.Post
import com.example.myvkapp.presentation.model.Profile
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): DataConverter<ProfileResponse, UserEntity>

    @Reusable
    @Binds
    fun bindProfileConverter(instance: ProfileConvert): Converter<UserEntity, Profile>

    @Reusable
    @Binds
    fun bindPostProfileConverter(instance: PostsConverter): DataConverter<PostsResponse, List<PostEntity>>

    @Reusable
    @Binds
    fun bindFeedPostConverter(instance: FeedPostConvertor): Converter<PostEntity,Post>
}