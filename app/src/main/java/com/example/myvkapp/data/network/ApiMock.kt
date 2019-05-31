package com.example.myvkapp.data.network

import com.example.myvkapp.data.response.Post
import com.example.myvkapp.data.response.PostsResponse
import com.example.myvkapp.data.response.ProfileResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

class ApiMock @Inject constructor() : Api {
    override fun login(name: String, password: String): Single<ProfileResponse> =
        if (name == "admin" && password == "123") {
            Single.just(
                ProfileResponse(
                    12345,
                    "Victor",
                    "Kosovskikh",
                    "https://pp.userapi.com/c623131/v623131993/518a3/skgbiwHUrEw.jpg",
                    "Seversk",
                    "Какой-то статус",
                    "8-999-495-46-90",
                    "22.11.1994"
                )
            )
        } else {
            Single.error(RuntimeException("UserEntity is not founded"))
        }
            .delay(2, TimeUnit.SECONDS)

    override fun getPosts(page: Int): Single<PostsResponse> =
        Single.just(
            PostsResponse((0..3).map{
            listOf(
                Post(
                    it,
                    "Message",
                    "",
                    Random.nextInt(0,100)
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
        }.flatten())
        )
            .delay(2,TimeUnit.SECONDS)

    override fun getProfile(id: Int): Single<ProfileResponse> =
        Single.just(
            ProfileResponse(
                12345,
                "Victor",
                "Kosovskikh",
                "https://pp.userapi.com/c623131/v623131993/518a3/skgbiwHUrEw.jpg",
                "Seversk",
                "Какой-то статус",
                "8-999-495-46-90",
                "22.11.1994"
            )
        ).delay(2, TimeUnit.SECONDS)
}