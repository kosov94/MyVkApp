package com.example.myvkapp.presentation.screen.profile.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myvkapp.R
import com.example.myvkapp.presentation.model.Profile
import kotlinx.android.synthetic.main.item_profile.view.*

class FeedProfileHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createInstance(parent: ViewGroup) = FeedProfileHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_profile,
                parent,
                false
            )
        )
    }

    fun bind(profile: Profile) {
        itemView.profileTextViewStatus.text = profile.status
        itemView.profileTextViewCity.text = profile.city
        itemView.profileTextViewPhone.text = profile.phone
        itemView.profileTextViewBirthday.text = profile.birthday
    }
}