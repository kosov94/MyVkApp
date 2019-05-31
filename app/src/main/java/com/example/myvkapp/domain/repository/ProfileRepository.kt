package com.example.myvkapp.domain.repository

import com.example.myvkapp.domain.entity.UserEntity
import io.reactivex.Single

interface ProfileRepository {
    fun getProfile(): Single<UserEntity>
}