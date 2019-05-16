package com.example.myvkapp.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import com.example.myvkapp.presentation.screen.profile.message.BaseMessage

interface ProfileView : MvpView {
    fun showProfile(firstName: String, birthday: String, city: String)
    fun showFeed(items: List<BaseMessage>)
    fun showAvatar(image: String)
}