package com.dygames.bandmates.feed

import com.dygames.bandmates.project.Project

data class Feed(
    val value: Map<Category, List<Project>>
)
