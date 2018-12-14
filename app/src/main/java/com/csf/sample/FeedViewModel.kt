package com.csf.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import java.util.concurrent.Executors

class FeedViewModel : ViewModel() {


    var articleLiveData: LiveData<PagedList<ProductionItemBean>>? = null
        private set

    init {
        init()
    }

    private fun init() {
       val  executor = Executors.newFixedThreadPool(5)

        val feedDataFactory = FeedDataFactory()
        //        networkState = Transformations.switchMap(feedDataFactory.getMutableLiveData(),
        //                dataSource -> dataSource.getNetworkState());

        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build()

        articleLiveData = LivePagedListBuilder(feedDataFactory, pagedListConfig)
                .setFetchExecutor(executor!!)
                .build()
    }
}
