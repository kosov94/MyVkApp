package com.example.myvkapp.data.converter

import com.example.myvkapp.data.response.PostsResponse
import com.example.myvkapp.domain.entity.PostEntity
import javax.inject.Inject

class PostsConverter @Inject constructor() :
    DataConverter<@kotlin.jvm.JvmSuppressWildcards PostsResponse, List<@kotlin.jvm.JvmSuppressWildcards PostEntity>> {
    override fun convert(t: PostsResponse): List<PostEntity> =
            t.posts.map {
                PostEntity(
                    it.id,
                    it.message,
                    it.image,
                    it.likes
                )
            }
}