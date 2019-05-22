package com.example.myvkapp.data.repository

import com.example.myvkapp.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor() : SessionRepository {

    override fun isAuth(): Boolean = true

}