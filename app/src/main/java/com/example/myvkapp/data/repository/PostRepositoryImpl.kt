package com.example.myvkapp.data.repository

import com.example.myvkapp.domain.repository.PostRepository
import com.example.myvkapp.presentation.common.BaseMessage
import com.example.myvkapp.presentation.model.Post
import javax.inject.Inject
import kotlin.random.Random

class PostRepositoryImpl @Inject constructor() : PostRepository {
    override fun getAll(): List<Post> =(1..3).map {
        listOf(
            Post(
                it,
                "Massage",
                "",
                Random.nextInt(0, 100)
            ),
            Post(
                it,
                "",
                "https://picsum.photos/id/$it/200/300",
                Random.nextInt(0, 100)
            ),
            Post(
                it,
                "Message",
                "https://picsum.photos/id/$it/200/300",
                Random.nextInt(0, 100)
            )
        )
    }.flatten()

    override fun getPost(id: Long): BaseMessage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}