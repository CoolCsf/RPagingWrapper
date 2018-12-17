package com.csf.paginglibrary.datasource

import androidx.paging.ItemKeyedDataSource

interface IItemKeyDataSource<Key, Source>  {
    fun loadInitial(
        params: ItemKeyedDataSource.LoadInitialParams<Key>,
        callback: ItemKeyedDataSource.LoadInitialCallback<Source>
    )

    fun loadAfter(params: ItemKeyedDataSource.LoadParams<Key>, callback: ItemKeyedDataSource.LoadCallback<Source>)
    fun loadBefore(params: ItemKeyedDataSource.LoadParams<Key>, callback: ItemKeyedDataSource.LoadCallback<Source>)
    fun getKey(item: Source): Key
}