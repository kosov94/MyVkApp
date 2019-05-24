package com.example.myvkapp.data.response

import com.google.gson.annotations.SerializedName

class ProfileResponse(
        @SerializedName("id") val id: Int,
        @SerializedName("firstName") val firstName: String,
        @SerializedName("lastName") val lastName: String,
        @SerializedName("avatar") val avatar: String,
        @SerializedName("city") val city: String,
        @SerializedName("status") val status: String,
        @SerializedName("phone") val phone: String,
        @SerializedName("birthday") val birthday: String

)