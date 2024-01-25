package com.dygames.bandmates.feed

interface FeedRepository {
    fun requestFeed(): Result<Feed>
}
