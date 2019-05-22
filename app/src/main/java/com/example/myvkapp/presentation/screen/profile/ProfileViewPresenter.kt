package com.example.myvkapp.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.domain.repository.PostRepository
import com.example.myvkapp.domain.repository.ProfileRepository
import com.example.myvkapp.presentation.model.Post
import com.example.myvkapp.presentation.model.Profile
import com.example.myvkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import kotlin.random.Random

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val router: Router,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository
) : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        setExampleData()
    }

    private fun setExampleData(){
        viewState.showProfile(profileRepository.getProfile())
        viewState.showFeed(postRepository.getAll())
    }

    fun logout() {
        router.newRootScreen(Screen.AuthViewScreen())
    }

    fun profileEdit() {
        router.navigateTo(Screen.ProfileEditScreen())
    }


}