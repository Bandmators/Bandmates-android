package com.dygames.bandmates.feed.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dygames.bandmates.feed.model.FeedUIState

class FeedAdapter : ListAdapter<FeedUIState, FeedViewHolder>(FeedDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): FeedViewHolder {
        return when (viewType) {
            1 -> FeedCategoryViewHolder(parent)
            else -> FeedProjectViewHolder(parent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is FeedUIState.Category -> 1
            is FeedUIState.Project -> 2
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<FeedUIState>?) {
        super.submitList(list)
    }
}
