package com.example.myvkapp.data.repository

import com.example.myvkapp.domain.repository.ProfileRepository
import com.example.myvkapp.presentation.model.Profile
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(): ProfileRepository {
    override fun getProfile(): Profile =Profile(
        12345,
        "Victor",
        "Kosovskikh",
        "https://pp.userapi.com/c623131/v623131993/518a3/skgbiwHUrEw.jpg"
    )
}