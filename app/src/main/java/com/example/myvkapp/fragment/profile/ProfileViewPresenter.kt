package com.example.myvkapp.fragment.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.App
import com.example.myvkapp.fragment.profile.message.CatMessage
import com.example.myvkapp.fragment.profile.message.PostMessage
import com.example.myvkapp.navigation.Screen

@InjectViewState
class ProfileViewPresenter : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile("Vitya", "22.11.1994","Tomsk")

        viewState.showFeed((1..100).map {
            if (it % 5 == 0) {
                CatMessage(
                    it,
                    "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
                )
            } else {
                PostMessage(
                    it,
                    "Message".repeat(30),
                    "https://picsum.photos/id/$it/200/300"
                )
            }
        })
    }

    fun logout() {
        App.INCTANCE.router.newRootScreen(Screen.AuthViewScreen())
    }


}