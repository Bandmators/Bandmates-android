package com.dygames.bandmates.feed.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dygames.bandmates.R
import com.dygames.bandmates.databinding.ActivityFeedBinding
import com.dygames.bandmates.feed.FeedViewModel
import com.dygames.bandmates.feed.data.DefaultFeedRepository
import com.dygames.bandmates.feed.view.recycler.FeedAdapter

class FeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private val feedViewModel: FeedViewModel = FeedViewModel(DefaultFeedRepository())
    private val feedAdapter: FeedAdapter = initAdapter()

    private external fun getAudioPCM(audio: String): IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()

        getAudioPCM("https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3").forEach {
            println(it)
        }
        feedViewModel.findFeed()
    }

    private fun initBinding() {
        binding =
            DataBindingUtil.setContentView<ActivityFeedBinding>(this, R.layout.activity_feed).also {
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

    companion object {
        init {
            System.loadLibrary("bandmates-audio-processing-android")
        }
    }
}
