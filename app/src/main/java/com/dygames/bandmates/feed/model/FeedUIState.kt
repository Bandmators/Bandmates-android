package com.dygames.bandmates.feed.model

sealed class FeedUIState {

    class Category(
        val name: String
    ) : FeedUIState()

    class Project(
        val name: String,
        val author: String
    ) : FeedUIState()
}
