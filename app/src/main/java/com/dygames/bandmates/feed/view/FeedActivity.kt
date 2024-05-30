package com.dygames.bandmates.feed.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dygames.bandmates.R
import com.dygames.bandmates.databinding.ActivityFeedBinding
import com.dygames.bandmates.feed.FeedViewModel
import com.dygames.bandmates.feed.data.DefaultFeedRepository
import com.dygames.bandmates.feed.view.recycler.FeedAdapter
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.BufferedInputStream
import java.io.IOException

class FeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private val feedViewModel: FeedViewModel = FeedViewModel(DefaultFeedRepository())
    private val feedAdapter: FeedAdapter = initAdapter()

    private external fun getAudioPCM(audio_data: ByteArray): IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()

        OkHttpClient().newCall(
            Request.Builder().url("https://samplelib.com/lib/preview/mp3/sample-12s.mp3")
                .build()
        ).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                print(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val inputStream = response.body?.byteStream()!!
                val ba = BufferedInputStream(inputStream).readBytes()
                val audioPCM = getAudioPCM(ba)
            }
        })

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
