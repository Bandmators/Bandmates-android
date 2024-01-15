package com.dygames.bandmates.feed.view.custom

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.dygames.bandmates.databinding.ViewProjectPreviewBinding

class ProjectPreview(
    context: Context
) : FrameLayout(context) {

    val binding: ViewProjectPreviewBinding =
        ViewProjectPreviewBinding.inflate(LayoutInflater.from(context), this, true)

}