package com.dygames.bandmates.feed.view.recycler

import androidx.recyclerview.widget.RecyclerView
import com.dygames.bandmates.feed.model.ProjectModel
import com.dygames.bandmates.feed.view.custom.ProjectPreview

class FeedProjectPreviewViewHolder(
    private val projectPreview: ProjectPreview
) : RecyclerView.ViewHolder(projectPreview) {

    fun bind(project: ProjectModel) {
        projectPreview.binding.project = project
    }
}