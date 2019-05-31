package com.example.myvkapp.domain.repository

import com.example.myvkapp.domain.entity.PostEntity
import io.reactivex.Single

interface PostRepository {
    fun getPosts(page: Int): Single<List<PostEntity>>

}