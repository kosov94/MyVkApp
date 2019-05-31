package com.example.myvkapp.presentation.converter

import com.example.myvkapp.domain.entity.UserEntity
import com.example.myvkapp.presentation.model.Profile
import javax.inject.Inject

class ProfileConvert @Inject constructor() : Converter<UserEntity, Profile> {
    override fun convert(t: UserEntity): Profile = Profile(
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