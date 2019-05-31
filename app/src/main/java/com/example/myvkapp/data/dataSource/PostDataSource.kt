package com.example.myvkapp.data.dataSource

import com.example.myvkapp.dagger.MockQualifier
import com.example.myvkapp.data.network.Api
import com.example.myvkapp.data.response.PostsResponse
import io.reactivex.Single
import javax.inject.Inject

interface PostDataSource {

    fun getPosts(page:Int): Single<PostsResponse>
}

class PostDataSourceImpl @Inject constructor(@MockQualifier private val api: Api):PostDataSource {
    override fun getPosts(page: Int): Single<PostsResponse> =
            api.getPosts(page)
}