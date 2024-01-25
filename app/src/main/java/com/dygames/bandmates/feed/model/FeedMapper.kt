package com.dygames.bandmates.feed.model

import com.dygames.bandmates.feed.Category
import com.dygames.bandmates.feed.Feed
import com.dygames.bandmates.project.Project

fun Feed.toModel() = FeedModel(value.keys.flatMap { category ->
    listOf(category.toModel()) + (value[category]?.map { it.toModel() } ?: emptyList())
})

fun Category.toModel() = FeedUIState.Category(
    name
)

fun Project.toModel() = FeedUIState.Project(
    name,
    author
)
