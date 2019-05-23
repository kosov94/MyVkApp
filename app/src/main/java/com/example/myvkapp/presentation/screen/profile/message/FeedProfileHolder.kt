package com.example.myvkapp.presentation.screen.profile.message

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myvkapp.presentation.model.Profile
import kotlinx.android.synthetic.main.item_profile.view.*

class FeedProfileHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(profile: Profile) {
        itemView.profileTextViewStatus.text = profile.status
        itemView.profileTextViewCity.text = profile.city
        itemView.profileTextViewPhone.text = profile.phone
        itemView.profileTextViewBirthday.text = profile.birthday
    }
}