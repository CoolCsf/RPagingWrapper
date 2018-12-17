package com.csf.paginglibrary.datasource

import androidx.paging.PositionalDataSource

interface IPositionDataSource<Key> {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Key>)
    fun loadInitial(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Key>)
}