package com.example.myvkapp.data.dataSource

import android.content.SharedPreferences
import javax.inject.Inject

interface SessionDataSource {

    fun setToken(token: String)

    fun clearToken()

    fun getToken(): String
}

class SessionDataSourceImpl @Inject constructor(
        private val sharedPreferences: SharedPreferences
) : SessionDataSource {

    private companion object {
        const val KEY_TOKEN = "authToken"
    }

    override fun setToken(token: String) = sharedPreferences.edit()
            .putString(KEY_TOKEN, token)
            .apply()

    override fun clearToken() = sharedPreferences.edit()
            .remove(KEY_TOKEN)
            .apply()

    override fun getToken(): String = sharedPreferences.getString(KEY_TOKEN, "").orEmpty()
}