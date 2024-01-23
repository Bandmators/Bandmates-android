package com.dygames.bandmates.feed.model

sealed class FeedUIState {

    class Category(
        val header: String
    ) : FeedUIState()

    class Project(
        val name: String
    ) : FeedUIState()
}
