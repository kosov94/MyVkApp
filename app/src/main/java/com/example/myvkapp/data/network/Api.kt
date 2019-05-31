package com.example.myvkapp.data.network

import com.example.myvkapp.data.response.PostsResponse
import com.example.myvkapp.data.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST
    fun login(name: String, password: String): Single<ProfileResponse>

    @GET("profile/{id}")
    fun getProfile(@Path("id") id:Int): Single<ProfileResponse>

    @GET("posts/page/{page}")
    fun getPosts(@Path("page")page:Int):Single<PostsResponse>

}