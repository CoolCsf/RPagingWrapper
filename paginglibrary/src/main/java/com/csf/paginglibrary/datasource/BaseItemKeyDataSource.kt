package com.csf.paginglibrary.datasource

import androidx.paging.ItemKeyedDataSource

class BaseItemKeyDataSource<Key, Source>(val recallBack: IItemKeyDataSource<Key, Source>) :
    ItemKeyedDataSource<Key, Source>() {
    override fun loadInitial(params: LoadInitialParams<Key>, callback: LoadInitialCallback<Source>) {
        recallBack.loadInitial(params, callback)
    }

    override fun loadAfter(params: LoadParams<Key>, callback: LoadCallback<Source>) {
        recallBack.loadAfter(params, callback)
    }

    override fun loadBefore(params: LoadParams<Key>, callback: LoadCallback<Source>) {
        recallBack.loadBefore(params, callback)
    }

    override fun getKey(item: Source): Key {
        return recallBack.getKey(item)
    }


}