package com.example.myvkapp.fragment.profile

import com.arellomobile.mvp.MvpView
import com.example.myvkapp.fragment.profile.message.BaseMessage
import java.util.*

interface ProfileView : MvpView {
    fun showProfile(firstName: String, birthday: String, city: String)
    fun showFeed(items: List<BaseMessage>)
}