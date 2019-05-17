package com.example.myvkapp.presentation.screen.profile.message

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myvkapp.presentation.loadImage
import com.example.myvkapp.presentation.model.Post
import kotlinx.android.synthetic.main.item_message.view.*

class FeedPostHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(data: Post) {
        if (data.message.isNotEmpty()) {
            itemView.cardMessageTextView.text = data.message
            itemView.cardMessageTextView.visibility = View.VISIBLE
        }

        if (data.image.isNotEmpty()) {
            itemView.cardMessageImageView.loadImage(data.image)
            itemView.cardMessageImageView.visibility = View.VISIBLE
        }

        itemView.cardPostLikesTextView.text = data.likes.toString()
    }
}