package com.example.myvkapp.data.converter

import com.example.myvkapp.data.response.ProfileResponse
import com.example.myvkapp.domain.entity.User
import javax.inject.Inject

class UserConverter @Inject constructor() : Converter<ProfileResponse, User> {
    override fun convertTo(t: ProfileResponse): User = User(
            t.id,
            t.firstName,
            t.lastName,
            t.avatar,
            t.status,
            t.city,
            t.phone,
            t.birthday
    )
}