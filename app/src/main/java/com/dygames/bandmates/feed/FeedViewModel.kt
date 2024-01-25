package com.dygames.bandmates.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dygames.bandmates.feed.data.DefaultFeedRepository
import com.dygames.bandmates.feed.model.FeedModel
import com.dygames.bandmates.feed.model.toModel
import kotlinx.coroutines.launch

class FeedViewModel(
    private val defaultFeedRepository: DefaultFeedRepository
) : ViewModel() {

    private val _feedLiveData: MutableLiveData<FeedModel> = MutableLiveData()
    val feedLiveData: LiveData<FeedModel>
        get() = _feedLiveData

    fun findFeed() {
        viewModelScope.launch {
            defaultFeedRepository.requestFeed().onSuccess {
                _feedLiveData.value = it.toModel()
            }.onFailure {

            }
        }
    }
}
