package com.example.myvkapp.dagger

import com.example.myvkapp.data.repository.PostRepositoryImpl
import com.example.myvkapp.data.repository.ProfileRepositoryImpl
import com.example.myvkapp.data.repository.SessionRepositoryImpl
import com.example.myvkapp.domain.repository.PostRepository
import com.example.myvkapp.domain.repository.ProfileRepository
import com.example.myvkapp.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface DataModule {
    @Reusable
    @Binds
    fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    fun bindSProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository
}