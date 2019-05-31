package com.example.myvkapp.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.myvkapp.domain.entity.PostEntity
import com.example.myvkapp.domain.repository.PostRepository
import com.example.myvkapp.domain.repository.ProfileRepository
import com.example.myvkapp.presentation.common.Paginator
import com.example.myvkapp.presentation.converter.FeedPostConvertor
import com.example.myvkapp.presentation.converter.ProfileConvert
import com.example.myvkapp.presentation.model.Post
import com.example.myvkapp.presentation.model.Profile
import com.example.myvkapp.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiConsumer
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import kotlin.random.Random

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val router: Router,
    private val profileConverter: ProfileConvert,
    private val feedPostConvertor: FeedPostConvertor,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository
) : MvpPresenter<ProfileView>() {

    private val paginator = Paginator(
            {
                postRepository.getPosts(it)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally { viewState.hideProgress() }
            },
            object : Paginator.ViewController<PostEntity> {
                override fun showEmptyProgress(show: Boolean) {
                    viewState.showProgress()
                }

                override fun showEmptyError(show: Boolean, error: Throwable?) {
                    viewState.showError()
                }

                override fun showEmptyView(show: Boolean) {

                }

                override fun showData(show: Boolean, data: List<PostEntity>) {
                    viewState.showFeed(
                            data.map { feedPostConvertor.convert(it) }
                    )
                }

                override fun showErrorMessage(error: Throwable) {
                    viewState.showError()
                }

                override fun showRefreshProgress(show: Boolean) {
                    viewState.showProgress()
                }

                override fun showPageProgress(show: Boolean) {
                    viewState.showProgress()
                }
            }
    )


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        setExampleData()
    }

    private fun setExampleData() {
        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.showProfile(profileConverter.convert(it)) },
                { viewState.showError() })

    }

    fun logout() {
        router.newRootScreen(Screen.AuthViewScreen())
    }

    fun profileEdit() {
        router.navigateTo(Screen.ProfileEditScreen())
    }

    fun refreshPaginator(){
        paginator.refresh()
    }

    fun loadPaginator(){
        paginator.loadNewPage()
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }


}