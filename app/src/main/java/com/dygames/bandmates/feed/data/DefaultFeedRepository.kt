package com.dygames.bandmates.feed.data

import com.dygames.bandmates.feed.Category
import com.dygames.bandmates.feed.Feed
import com.dygames.bandmates.feed.FeedRepository
import com.dygames.bandmates.project.Project

class DefaultFeedRepository : FeedRepository {
    override fun requestFeed(): Result<Feed> {
        return Result.success(
            Feed(
                mapOf(
                    Category("Category 1") to listOf(
                        Project("Project 1", "Author 1"), Project("Project 2", "Author 2")
                    ), Category("Category 2") to listOf(
                        Project("Project 3", "Author 3"), Project("Project 4", "Author 4"), Project("Project 5", "Author 5")
                    )
                )
            )
        )
    }
}
