package com.dygames.bandmates.feed.view.recycler

import androidx.recyclerview.widget.DiffUtil
import com.dygames.bandmates.feed.model.ProjectModel

class FeedDiffUtil : DiffUtil.ItemCallback<ProjectModel>() {
    override fun areItemsTheSame(oldItem: ProjectModel, newItem: ProjectModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProjectModel, newItem: ProjectModel): Boolean {
        return oldItem.name == newItem.name
    }
}