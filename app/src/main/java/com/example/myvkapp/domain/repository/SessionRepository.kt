package com.example.myvkapp.domain.repository

import com.example.myvkapp.domain.entity.UserEntity
import io.reactivex.Single

interface SessionRepository {

    fun login(name: String, password: String): Single<UserEntity>

    fun isAuth(): Boolean

}