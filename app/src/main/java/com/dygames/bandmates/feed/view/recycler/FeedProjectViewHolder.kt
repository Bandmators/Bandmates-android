package com.dygames.bandmates.feed.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dygames.bandmates.databinding.ViewFeedProjectBinding
import com.dygames.bandmates.feed.model.FeedUIState

class FeedProjectViewHolder(
    parent: ViewGroup,
    private val binding: ViewFeedProjectBinding =
        ViewFeedProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
) : FeedViewHolder(binding.root) {

    override fun bind(feed: FeedUIState) {
        binding.project = (feed as FeedUIState.Project)
    }
}
