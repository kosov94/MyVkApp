package com.example.myvkapp.data.dataSource

import com.example.myvkapp.dagger.MockQualifier
import com.example.myvkapp.data.network.Api
import com.example.myvkapp.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

interface ProfileDataSource {

    fun getProfile(): Single<ProfileResponse>
}

class ProfileDataSourceImpl @Inject constructor(@MockQualifier private val api: Api) : ProfileDataSource {
    override fun getProfile(): Single<ProfileResponse> =
        api.getProfile(12345)

}