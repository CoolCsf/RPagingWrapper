package com.csf.paginglibrary.datasource

import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import java.util.concurrent.Executors

class BasePagingAdapterWrapper<Key, Source> {
    private var mDataSource: DataSource<Key, Source>? = null
    var pageSize: Int = 10
        private set
    var enablePlaceholders = false
        private set
    var initialLoadSizeHint = pageSize
        private set
    var executorNumber = 5
        private set
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

    fun setPageDataSource(dataSource: BasePageKeyDataSource<Key, Source>): BasePagingAdapterWrapper<Key, Source> {
        mDataSource = dataSource
        return this
    }

    fun setItemDataSource(dataSource: BaseItemKeyDataSource<Key, Source>): BasePagingAdapterWrapper<Key, Source> {
        mDataSource = dataSource
        return this
    }

    fun setPositionDataSource(dataSource: BasePositionDataSource<Key>): BasePagingAdapterWrapper<Key, Source> {
        mDataSource = dataSource as DataSource<Key, Source>
        return this
    }

    fun setPageSize(pageSize: Int): BasePagingAdapterWrapper<Key, Source> {
        this.pageSize = pageSize
        return this
    }

    fun setEnablePlaceholders(enablePlaceholders: Boolean): BasePagingAdapterWrapper<Key, Source> {
        this.enablePlaceholders = enablePlaceholders
        return this
    }

    fun setInitialLoadSizeHint(initialLoadSizeHint: Int): BasePagingAdapterWrapper<Key, Source> {
        this.initialLoadSizeHint = initialLoadSizeHint
        return this
    }

    fun setExecutorNumber(executorNumber: Int): BasePagingAdapterWrapper<Key, Source> {
        this.executorNumber = executorNumber
        return this
    }

    inner class BaseDataSourceFactory<Key, Source> : DataSource.Factory<Key, Source>() {
        override fun create(): DataSource<Key, Source> {
            @Suppress("UNCHECKED_CAST")
            return mDataSource as DataSource<Key, Source>
        }
    }
}