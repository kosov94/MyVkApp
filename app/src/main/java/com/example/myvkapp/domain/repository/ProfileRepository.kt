package com.example.myvkapp.domain.repository

import com.example.myvkapp.presentation.model.Profile

interface ProfileRepository {
    fun getProfile(): Profile
}