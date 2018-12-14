package com.csf.paginglibrary.datasource

import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import java.util.concurrent.Executors

class BasePagingAdapterWrapper<Key, Source> {
    private var mDataSource: IBaseDataSource<Key, Source>? = null
    var pageSize: Int = 10
    var enablePlaceholders = false
    var initialLoadSizeHint = pageSize
    var executorNumber = 5
    val dataSourceLiveData by lazy {
        val executor = Executors.newFixedThreadPool(executorNumber)
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(enablePlaceholders)
            .setInitialLoadSizeHint(initialLoadSizeHint)
            .setPageSize(pageSize).build()
        LivePagedListBuilder(dataSourceFactory, pagedListConfig).setFetchExecutor(executor).build()
    }
    private val dataSourceFactory by lazy {
        return@lazy BaseDataSourceFactory<Key, Source>()
    }

    fun setDataSource(dataSource: IBaseDataSource<Key, Source>): BasePagingAdapterWrapper<Key, Source> {
        mDataSource = dataSource
        return this
    }

    inner class BaseDataSourceFactory<Key, Source> : DataSource.Factory<Key, Source>() {
        override fun create(): DataSource<Key, Source> {
            @Suppress("UNCHECKED_CAST")
            return mDataSource as DataSource<Key, Source>
        }
    }
}