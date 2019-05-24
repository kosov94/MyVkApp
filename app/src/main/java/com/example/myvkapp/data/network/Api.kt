package com.example.myvkapp.data.network

import com.example.myvkapp.data.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.POST

interface Api {

    @POST
    fun login(name: String, password: String): Single<ProfileResponse>

}