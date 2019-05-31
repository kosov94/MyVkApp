package com.example.myvkapp.data.converter

import com.example.myvkapp.data.response.ProfileResponse
import com.example.myvkapp.domain.entity.UserEntity
import javax.inject.Inject

class UserConverter @Inject constructor() : DataConverter<ProfileResponse, UserEntity> {
    override fun convert(t: ProfileResponse): UserEntity = UserEntity(
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