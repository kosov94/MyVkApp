package com.example.myvkapp.data.dataSource

import com.example.myvkapp.dagger.MockQualifier
import com.example.myvkapp.data.network.Api
import com.example.myvkapp.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

interface AuthDataSource {

    fun login(name: String, password: String): Single<ProfileResponse>
}

class AuthDataSourceImpl @Inject constructor(@MockQualifier private val api: Api) : AuthDataSource {
    override fun login(name: String, password: String): Single<ProfileResponse> =
        api.login(name, password)

}