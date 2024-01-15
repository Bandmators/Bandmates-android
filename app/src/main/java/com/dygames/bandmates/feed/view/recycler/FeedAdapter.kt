package com.dygames.bandmates.feed.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dygames.bandmates.feed.model.ProjectModel
import com.dygames.bandmates.feed.view.custom.ProjectPreview

class FeedAdapter : ListAdapter<ProjectModel, FeedProjectPreviewViewHolder>(FeedDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): FeedProjectPreviewViewHolder {
        return FeedProjectPreviewViewHolder(
            ProjectPreview(parent.context)
        )
    }

    override fun onBindViewHolder(holder: FeedProjectPreviewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<ProjectModel>?) {
        super.submitList(list)
    }
}