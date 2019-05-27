package com.example.myvkapp.presentation.screen.profile.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseMessage
import com.example.myvkapp.presentation.common.loadImage
import com.example.myvkapp.presentation.model.Post
import com.example.myvkapp.presentation.model.Profile
import java.lang.IllegalArgumentException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val MESSAGE = 1
        const val CAT_MESSAGE = 2
        const val PROFILE_POST = 3
    }

    private val items: MutableList<BaseMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        MESSAGE -> FeedPostHolder.createInstance(parent)
        PROFILE_POST -> FeedProfileHolder.createInstance(parent)

        else -> throw IllegalArgumentException("viewType $viewType not found")
    }

    override fun getItemViewType(position: Int): Int {

        return when (items[position]) {
            is CatMessage -> CAT_MESSAGE
            is Post -> MESSAGE
            is Profile -> PROFILE_POST

            else -> throw IllegalArgumentException("${items[position].javaClass} not found")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FeedPostHolder -> holder.bind(items[position] as Post)
            is CatHolder -> holder.bind(items[position] as CatMessage)
            is FeedProfileHolder -> holder.bind(items[position] as Profile)
        }
    }

    fun setPosts(items_list: List<BaseMessage>) {
        val profile = items[0]
        items.clear()
        items.add(profile)
        items.addAll(items_list)
        notifyDataSetChanged()
    }

    fun setProfile(profile: Profile) {
        if (items.isEmpty())
            items.add(profile)
        else
            this.items[0] = profile
        notifyItemChanged(0)
    }


    inner class CatHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: CatMessage) {
            (itemView as ImageView).loadImage(data.image)
        }
    }
}