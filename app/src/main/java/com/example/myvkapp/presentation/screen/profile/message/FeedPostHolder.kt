package com.example.myvkapp.presentation.screen.profile.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.loadImage
import com.example.myvkapp.presentation.model.Post
import kotlinx.android.synthetic.main.item_message.view.*

class FeedPostHolder(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        fun createInstance(parent: ViewGroup) = FeedPostHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_message,
                parent,
                false
            )
        )
    }

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