package com.example.myvkapp.presentation.screen.profile.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myvkapp.R
import com.example.myvkapp.presentation.common.BaseMessage
import com.example.myvkapp.presentation.loadImage
import com.example.myvkapp.presentation.model.Post
import kotlinx.android.synthetic.main.item_post_message.view.*
import kotlinx.android.synthetic.main.item_text_message.view.*
import java.lang.IllegalArgumentException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val MESSAGE = 1
        const val CAT_MESSAGE = 2
    }

    private val items: MutableList<BaseMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        MESSAGE -> FeedPostHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_message,
                parent,
                false
            )
        )
        else -> throw IllegalArgumentException("viewType $viewType not found")
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is CatMessage -> CAT_MESSAGE
        is Post -> MESSAGE

        else -> throw IllegalArgumentException("${items[position].javaClass} not found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FeedPostHolder -> holder.bind(items[position] as Post)
            is CatHolder -> holder.bind(items[position] as CatMessage)

        }
    }

    fun setItems(items: List<BaseMessage>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }


    inner class CatHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: CatMessage) {
            (itemView as ImageView).loadImage(data.image)
        }
    }
}