package com.dygames.bandmates.feed.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dygames.bandmates.R
import com.dygames.bandmates.databinding.ActivityFeedBinding
import com.dygames.bandmates.feed.FeedViewModel
import com.dygames.bandmates.feed.data.FeedRepository
import com.dygames.bandmates.feed.view.recycler.FeedAdapter

class FeedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedBinding
    private val feedViewModel: FeedViewModel = FeedViewModel(FeedRepository())
    private val feedAdapter: FeedAdapter = initAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        feedViewModel.findFeed()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView<ActivityFeedBinding>(this, R.layout.activity_feed)
            .also {
                it.lifecycleOwner = this
                it.adapter = feedAdapter
            }

        feedViewModel.feedLiveData.observe(this) {
            feedAdapter.submitList(it.value.toMutableList())
        }
    }

    private fun initAdapter(): FeedAdapter {
        return FeedAdapter()
    }
}