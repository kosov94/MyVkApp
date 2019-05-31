package com.example.myvkapp.domain.entity

data class UserEntity (
        val id: Int,
        val firstName: String,
        val lastName: String,
        val avatar: String,
        val city: String,
        val status: String,
        val phone: String,
        val birthday: String
)