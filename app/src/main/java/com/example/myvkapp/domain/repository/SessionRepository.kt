package com.example.myvkapp.domain.repository

import com.example.myvkapp.domain.entity.User
import io.reactivex.Single

interface SessionRepository {

    fun login(name: String, password: String): Single<User>

    fun isAuth(): Boolean

}