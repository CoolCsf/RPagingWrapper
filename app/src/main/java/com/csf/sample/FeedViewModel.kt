package com.csf.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.csf.paginglibrary.datasource.BasePageKeyDataSource
import com.csf.paginglibrary.datasource.BasePagingAdapterWrapper
import com.csf.paginglibrary.datasource.IPageKeyDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel : ViewModel() {

    var articleLiveData: LiveData<PagedList<ProductionItemBean>>? = null
        private set

    init {
        init()
    }

    private fun init() {
//        articleLiveData = BasePagingAdapterWrapper<Long, ProductionItemBean>().setDataSource(object :
//            BasePageKeyDataSource<Long, ProductionItemBean>() {
//
//        }).dataSourceLiveData
    }

    fun getProduction() {

    }
}
