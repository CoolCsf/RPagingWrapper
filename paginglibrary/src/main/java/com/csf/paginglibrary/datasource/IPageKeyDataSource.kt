package com.csf.paginglibrary.datasource

import androidx.paging.PageKeyedDataSource

interface IPageKeyDataSource<Key, Source> : IBaseDataSource<Key, Source> {
    fun loadInitial(
        params: PageKeyedDataSource.LoadInitialParams<Key>,
        callback: PageKeyedDataSource.LoadInitialCallback<Key, Source>
    )

    fun loadAfter(params: PageKeyedDataSource.LoadParams<Key>, callback: PageKeyedDataSource.LoadCallback<Key, Source>)
    fun loadBefore(params: PageKeyedDataSource.LoadParams<Key>, callback: PageKeyedDataSource.LoadCallback<Key, Source>)
}