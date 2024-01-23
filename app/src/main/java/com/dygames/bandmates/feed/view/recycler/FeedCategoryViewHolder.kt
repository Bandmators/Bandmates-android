package com.dygames.bandmates.feed.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dygames.bandmates.databinding.ViewFeedCategoryBinding
import com.dygames.bandmates.feed.model.FeedUIState

class FeedCategoryViewHolder(
    parent: ViewGroup,
    private val binding: ViewFeedCategoryBinding =
        ViewFeedCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
) : FeedViewHolder(binding.root) {

    override fun bind(feed: FeedUIState) {
        binding.category = (feed as FeedUIState.Category)
    }
}
