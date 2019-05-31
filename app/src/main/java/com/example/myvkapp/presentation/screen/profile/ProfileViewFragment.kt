package com.example.myvkapp.presentation.screen.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseFragment
import com.example.myvkapp.presentation.common.BaseMessage
import com.example.myvkapp.presentation.common.loadImage
import com.example.myvkapp.presentation.model.Profile
import com.example.myvkapp.presentation.screen.profile.message.FeedAdapter
import kotlinx.android.synthetic.main.fragment_profile_view.*
import timber.log.Timber
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

        profileRefresh.setOnRefreshListener(presenter::refreshPaginator)
    }

    private fun initFeed() {
        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    override fun showProfile(profile: Profile) {
        profileViewCollapsingToolbar.title = "${profile.lastName} ${profile.firstName}"
        profileViewAvatar.loadImage(profile.avatar)
        feedAdapter.setProfile(profile)
    }

    override fun showError() {
        Toast.makeText(activity,"Network Error",Toast.LENGTH_LONG).show()
        Timber.d("Profile: feed error")
    }

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setPosts(items)
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

    override fun showProgress() {
        profileRefresh.isRefreshing = true
    }

    override fun hideProgress() {
        profileRefresh.isRefreshing = false
    }

    override fun showAvatar(image: String) {

    }
}