package com.example.myvkapp.navigation

import androidx.fragment.app.Fragment
import com.example.myvkapp.fragment.auth.AuthViewFragment
import com.example.myvkapp.fragment.profile.ProfileViewFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class ProfileViewScreen : Screen(ProfileViewFragment())
    class AuthViewScreen: Screen(AuthViewFragment())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}