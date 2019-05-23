package com.example.myvkapp.presentation.model

import com.example.myvkapp.presentation.common.BaseMessage

class Profile(
        id: Int,
        val firstName: String,
        val lastName: String,
        val avatar: String,
        val city: String,
        val status: String,
        val phone: String,
        val birthday: String
) : BaseMessage(id)