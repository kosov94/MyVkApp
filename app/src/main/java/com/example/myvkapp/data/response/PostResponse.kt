package com.example.myvkapp.data.response

import com.google.gson.annotations.SerializedName

class PostsResponse (
    @SerializedName("posts") val posts: List<Post>
    )

class Post(
    @SerializedName("id") val id:Int,
    @SerializedName("message") val message: String,
    @SerializedName("image") val image: String,
    @SerializedName("likes") val likes: Int
)