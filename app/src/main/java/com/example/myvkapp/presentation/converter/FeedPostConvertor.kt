package com.example.myvkapp.presentation.converter

import com.example.myvkapp.domain.entity.PostEntity
import com.example.myvkapp.presentation.model.Post
import javax.inject.Inject

class FeedPostConvertor @Inject constructor(): Converter<PostEntity, Post> {
    override fun convert(t: PostEntity): Post =
            Post(
                    t.id,
                    t.message,
                    t.image,
                    t.likes
            )
}