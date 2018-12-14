package com.csf.paginglibrary.datasource

import androidx.paging.PageKeyedDataSource

class BasePageKeyDataSource<Key, Source>(val recallBack: IPageKeyDataSource<Key, Source>) :
    PageKeyedDataSource<Key, Source>() {
    override fun loadInitial(params: LoadInitialParams<Key>, callback: LoadInitialCallback<Key, Source>) {
        recallBack.loadInitial(params, callback)
    }

    override fun loadAfter(params: LoadParams<Key>, callback: LoadCallback<Key, Source>) {
        recallBack.loadAfter(params, callback)
    }

    override fun loadBefore(params: LoadParams<Key>, callback: LoadCallback<Key, Source>) {
        recallBack.loadBefore(params, callback)
    }

}