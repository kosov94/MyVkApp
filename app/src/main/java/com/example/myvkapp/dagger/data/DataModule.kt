package com.example.myvkapp.dagger.data

import android.content.Context
import android.content.SharedPreferences
import com.example.myvkapp.App
import com.example.myvkapp.data.dataSource.*
import com.example.myvkapp.data.repository.PostRepositoryImpl
import com.example.myvkapp.data.repository.ProfileRepositoryImpl
import com.example.myvkapp.data.repository.SessionRepositoryImpl
import com.example.myvkapp.domain.repository.PostRepository
import com.example.myvkapp.domain.repository.ProfileRepository
import com.example.myvkapp.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(
    includes = [
        NetworkModule::class,
        ConverterModule::class
    ])
abstract class DataModule {

    @Module
    companion object {

        @JvmStatic
        @Reusable
        @Provides
        fun provideSharedPreferences(app: App): SharedPreferences =
                app.getSharedPreferences("CommonSharedPreferences", Context.MODE_PRIVATE)

    }

    @Reusable
    @Binds
    abstract fun bindSessionDataSource(instance: SessionDataSourceImpl): SessionDataSource

    @Reusable
    @Binds
    abstract fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    abstract fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    abstract fun bindSProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

    @Reusable
    @Binds
    abstract fun bindProfileDataSource(instance: ProfileDataSourceImpl): ProfileDataSource

    @Reusable
    @Binds
    abstract fun bindAuthDataSource(instance: AuthDataSourceImpl): AuthDataSource

    @Reusable
    @Binds
    abstract fun bindPostsDataSourse(instance: PostDataSourceImpl): PostDataSource
}