package com.example.myvkapp.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.myvkapp.R
import com.example.myvkapp.fragment.BaseFragment
import com.example.myvkapp.fragment.profile.message.BaseMessage
import kotlinx.android.synthetic.main.fragment_profile_view.*
import java.util.*

class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view), ProfileView {

    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    private val feedAdapter = FeedAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
    }

    private fun initFeed() {
        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    override fun showProfile(firstName: String, birthday: String, city: String) {
        profileViewFirstName.text = firstName
        profileViewBirthday.text = birthday
        profileViewCity.text = city
    }

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
    }

    private fun initToolbar() {
        profileViewToolbar.inflateMenu(R.menu.menu_profile_view)
        profileViewToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_profile_edit -> presenter.profileEdit()
                R.id.action_logout -> presenter.logout()
            }

            true
        }
    }

    override fun showAvatar(image: String) {

    }
}