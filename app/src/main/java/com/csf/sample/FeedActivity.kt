package com.csf.sample

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.csf.sample.databinding.ActivityMainBinding

class FeedActivity : AppCompatActivity() {

    //    private FeedListAdapter adapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
         * Step 1: Using DataBinding, we setup the layout for the activity
         *
         * */
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val feedViewModel = FeedViewModel()
        binding.rvTest.layoutManager = LinearLayoutManager(this)
        val adapter = FeedListAdapter()
        feedViewModel.articleLiveData!!.observe(this, Observer<PagedList<ProductionItemBean>> { adapter.submitList(it) })
        binding.rvTest.adapter = adapter
        //
        //        /*
        //         * Step 2: Initialize the ViewModel
        //         *
        //         * */
        //        FeedViewModel feedViewModel = new FeedViewModel(AppController.create(this));
        //
        //        /*
        //         * Step 2: Setup the adapter class for the RecyclerView
        //         *
        //         * */
        //        binding.listFeed.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //        adapter = new FeedListAdapter(getApplicationContext());
        //
        //
        //        /*
        //         * Step 4: When a new page is available, we call submitList() method
        //         * of the PagedListAdapter class
        //         *
        //         * */
        //        feedViewModel.getArticleLiveData().observe(this, pagedList -> {
        //            adapter.submitList(pagedList);
        //        });
        //
        //        /*
        //         * Step 5: When a new page is available, we call submitList() method
        //         * of the PagedListAdapter class
        //         *
        //         * */
        ////        feedViewModel.getNetworkState().observe(this, networkState -> {
        ////            adapter.setNetworkState(networkState);
        ////        });
        //
        //        binding.listFeed.setAdapter(adapter);
    }
}
