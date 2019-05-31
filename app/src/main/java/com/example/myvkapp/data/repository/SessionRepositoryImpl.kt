package com.example.myvkapp.data.repository


import com.example.myvkapp.data.converter.DataConverter
import com.example.myvkapp.data.dataSource.AuthDataSource
import com.example.myvkapp.data.response.ProfileResponse
import com.example.myvkapp.domain.entity.UserEntity
import com.example.myvkapp.domain.repository.SessionRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
        private val converter: DataConverter<ProfileResponse, UserEntity>
) : SessionRepository {

    override fun isAuth(): Boolean = true

    override fun login(name: String, password: String): Single<UserEntity> =
            authDataSource.login(name, password).
                    subscribeOn(Schedulers.io()).
                    map(converter::convert)
}