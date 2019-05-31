package com.example.myvkapp.data.repository

import com.example.myvkapp.data.converter.UserConverter
import com.example.myvkapp.data.dataSource.ProfileDataSource
import com.example.myvkapp.domain.entity.UserEntity
import com.example.myvkapp.domain.repository.ProfileRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileDataSource,
    private val userConverter: UserConverter
) : ProfileRepository {
    override fun getProfile(): Single<UserEntity> =
        profileDataSource.getProfile()
            .subscribeOn(Schedulers.io())
            .map(userConverter::convert)

}