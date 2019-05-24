package com.example.myvkapp.data.repository

import com.example.myvkapp.data.converter.Converter
import com.example.myvkapp.data.network.Api
import com.example.myvkapp.data.response.ProfileResponse
import com.example.myvkapp.domain.entity.User
import com.example.myvkapp.domain.repository.SessionRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
        private val api: Api,
        private val converter: Converter<ProfileResponse, User>
) : SessionRepository {

    override fun isAuth(): Boolean = true

    override fun login(name: String, password: String): Single<User> =
            api.login(name, password).
                    subscribeOn(Schedulers.io()).
                    map(converter::convertTo)
}