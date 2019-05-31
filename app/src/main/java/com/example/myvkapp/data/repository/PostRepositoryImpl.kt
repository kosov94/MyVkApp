package com.example.myvkapp.data.repository

import com.example.myvkapp.data.converter.DataConverter
import com.example.myvkapp.data.dataSource.PostDataSource
import com.example.myvkapp.data.response.PostsResponse
import com.example.myvkapp.domain.entity.PostEntity
import com.example.myvkapp.domain.repository.PostRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
        private val postDataSource: PostDataSource,
        private val postsConverter: DataConverter<PostsResponse, List<PostEntity>>
) : PostRepository {

    override fun getPosts(page: Int): Single<List<PostEntity>> =
            postDataSource.getPosts(page)
                    .subscribeOn(Schedulers.io())
                    .map(postsConverter::convert)


}