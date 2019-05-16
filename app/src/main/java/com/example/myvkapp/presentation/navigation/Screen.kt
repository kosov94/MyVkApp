package com.example.myvkapp.presentation.navigation

import androidx.fragment.app.Fragment
import com.example.myvkapp.presentation.screen.auth.AuthViewFragment
import com.example.myvkapp.presentation.screen.profile.ProfileViewFragment
import com.example.myvkapp.presentation.screen.profileEdit.ProfileEditViewFragment
import com.example.myvkapp.presentation.screen.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class ProfileViewScreen : Screen(ProfileViewFragment())
    class AuthViewScreen: Screen(AuthViewFragment())
    class ProfileEditScreen: Screen(ProfileEditViewFragment())
    class SpalshScreen: Screen(SplashFragment())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}