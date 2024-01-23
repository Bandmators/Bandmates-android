package com.dygames.bandmates.feed.view.recycler

import androidx.recyclerview.widget.DiffUtil
import com.dygames.bandmates.feed.model.FeedUIState

class FeedDiffUtil : DiffUtil.ItemCallback<FeedUIState>() {
    override fun areItemsTheSame(oldItem: FeedUIState, newItem: FeedUIState): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FeedUIState, newItem: FeedUIState): Boolean {
        return oldItem::class == newItem::class
    }
}
