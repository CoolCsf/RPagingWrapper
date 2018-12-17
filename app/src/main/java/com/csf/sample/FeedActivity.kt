package com.csf.sample

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.csf.sample.databinding.ActivityMainBinding
import com.csf.sample.model.Article
import kotlinx.android.synthetic.main.activity_main.*

class FeedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val feedViewModel = FeedViewModel()
        rv_test.layoutManager = LinearLayoutManager(this)
        val adapter = FeedListAdapter()
        feedViewModel.articleLiveData!!.observe(
            this,
            Observer<PagedList<Article>> { adapter.submitList(it) })
        rv_test.adapter = adapter
    }
}
