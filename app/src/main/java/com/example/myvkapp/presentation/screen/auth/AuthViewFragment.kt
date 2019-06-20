package com.example.myvkapp.presentation.screen.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

class AuthViewFragment : BaseFragment(R.layout.fragment_auth), AuthView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthViewPresenter

    @ProvidePresenter
    fun providePresenter(): AuthViewPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSignIn.setOnClickListener {
                    presenter.signInClick(authLogin.text.toString(),
                    authPassword.text.toString())
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}
