package com.csf.paginglibrary.datasource

import androidx.paging.PositionalDataSource

class BasePositionDataSource<Key>(private val recallBack: IPositionDataSource<Key>) : PositionalDataSource<Key>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Key>) {
        recallBack.loadRange(params, callback)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Key>) {
        recallBack.loadInitial(params, callback)
    }

}