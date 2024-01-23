package com.dygames.bandmates.feed.view.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dygames.bandmates.feed.model.FeedUIState

abstract class FeedViewHolder(
    parent: View
) : ViewHolder(parent) {
    abstract fun bind(feed: FeedUIState)
}
