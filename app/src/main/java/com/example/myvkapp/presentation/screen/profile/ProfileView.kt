package com.example.myvkapp.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import com.example.myvkapp.presentation.common.BaseMessage
import com.example.myvkapp.presentation.model.Profile

interface ProfileView : MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<BaseMessage>)
    fun showAvatar(image: String)
    fun showError()
    fun showProgress()
    fun hideProgress()
}