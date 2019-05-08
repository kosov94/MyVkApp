package com.example.myvkapp.fragment.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.myvkapp.R
import com.example.myvkapp.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthViewFragment : BaseFragment(R.layout.fragment_auth), AuthView {
    @InjectPresenter
    lateinit var presenter: AuthViewPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSignIn.setOnClickListener { presenter.signInClick(authLogin.text.toString(), authPassword.text.toString()) }
    }

    override fun showToast(message: String){
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }

}
