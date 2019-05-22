package com.example.myvkapp.domain.repository

import com.example.myvkapp.presentation.common.BaseMessage

interface PostRepository {
    fun getAll(): List<BaseMessage>

    fun getPost(id: Long): BaseMessage
}