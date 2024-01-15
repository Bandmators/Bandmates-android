package com.dygames.bandmates.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dygames.bandmates.feed.data.FeedRepository
import com.dygames.bandmates.feed.model.FeedModel
import com.dygames.bandmates.feed.model.ProjectModel

class FeedViewModel(
    private val feedRepository: FeedRepository
) : ViewModel() {

    private val _feedLiveData: MutableLiveData<FeedModel> = MutableLiveData()
    val feedLiveData: LiveData<FeedModel>
        get() = _feedLiveData

    fun findFeed() {
        _feedLiveData.value  = FeedModel(
            (0..10).map {
                ProjectModel(it.toString())
            }
        )
    }
}