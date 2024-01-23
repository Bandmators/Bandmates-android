package com.dygames.bandmates.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dygames.bandmates.feed.data.FeedRepository
import com.dygames.bandmates.feed.model.FeedModel
import com.dygames.bandmates.feed.model.FeedUIState

class FeedViewModel(
    private val feedRepository: FeedRepository
) : ViewModel() {

    private val _feedLiveData: MutableLiveData<FeedModel> = MutableLiveData()
    val feedLiveData: LiveData<FeedModel>
        get() = _feedLiveData

    fun findFeed() {
        _feedLiveData.value  = FeedModel(
            listOf(
                FeedUIState.Category("Cat 1"),
                FeedUIState.Project("Project 1"),
                FeedUIState.Project("Project 2"),
                FeedUIState.Category("Cat 2"),
                FeedUIState.Project("Project 1"),
                FeedUIState.Project("Project 2"),
                FeedUIState.Project("Project 3"),
            )
        )
    }
}
