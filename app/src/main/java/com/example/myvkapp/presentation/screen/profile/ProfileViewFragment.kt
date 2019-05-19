package com.example.myvkapp.presentation.screen.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseFragment
import com.example.myvkapp.presentation.common.BaseMessage
import com.example.myvkapp.presentation.common.loadImage
import com.example.myvkapp.presentation.model.Profile
import com.example.myvkapp.presentation.screen.profile.message.FeedAdapter
import kotlinx.android.synthetic.main.fragment_profile_view.*
import javax.inject.Inject

class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view),
    ProfileView {

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter = presenter

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

    override fun showProfile(profile: Profile) {
        profileViewCollapsingToolbar.title="${profile.lastName} ${profile.firstName}"
        profileViewAvatar.loadImage(profile.avatar)
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