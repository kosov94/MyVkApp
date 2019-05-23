package com.example.myvkapp.presentation.model

import com.example.myvkapp.presentation.common.BaseMessage

class Post(
        id: Int,
        val message: String,
        val image: String,
        val likes: Int
) : BaseMessage(id)