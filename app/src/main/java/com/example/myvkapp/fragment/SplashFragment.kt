package com.example.myvkapp.fragment

import com.example.myvkapp.App
import com.example.myvkapp.R
import com.example.myvkapp.navigation.Screen
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun onResume() {
        super.onResume()

        asd.postDelayed({
            App.INCTANCE.router.replaceScreen(Screen.ProfileViewScreen())
        }, 3000)
    }

}