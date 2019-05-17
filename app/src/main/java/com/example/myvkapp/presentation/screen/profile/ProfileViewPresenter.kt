package com.example.myvkapp.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.App
import com.example.myvkapp.presentation.model.Post
import com.example.myvkapp.presentation.model.Profile
import com.example.myvkapp.presentation.navigation.Screen
import kotlin.random.Random

@InjectViewState
class ProfileViewPresenter : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(Profile(
            12345,
            "Victor",
            "Kosovskikh",
            "https://pp.userapi.com/c623131/v623131993/518a3/skgbiwHUrEw.jpg"
        ))

        viewState.showFeed((1..3).map {
            listOf(
                Post(
                    it,
                    "Massage",
                    "",
                    Random.nextInt(0, 100)
                ),
                Post(
                    it,
                    "",
                    "https://picsum.photos/id/$it/200/300",
                    Random.nextInt(0, 100)
                ),
                Post(
                    it,
                    "Message",
                    "https://picsum.photos/id/$it/200/300",
                    Random.nextInt(0, 100)
                )
            )
        }.flatten())

    }

    fun logout() {
        App.INCTANCE.router.newRootScreen(Screen.AuthViewScreen())
    }

    fun profileEdit() {
        App.INCTANCE.router.navigateTo(Screen.ProfileEditScreen())
    }


}