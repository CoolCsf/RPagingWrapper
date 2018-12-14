package com.csf.sample

import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FeedDataSource : PageKeyedDataSource<Long, ProductionItemBean>() {
    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, ProductionItemBean>) {
        AppController.create().restApi.getProducts("19973170908", "a12345678", "0",
                "0", "1").enqueue(object : Callback<GetProductsResponse> {
            override fun onFailure(call: Call<GetProductsResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<GetProductsResponse>, response: Response<GetProductsResponse>) {
                if (response.isSuccessful) {
                    callback.onResult(response.body()?.getProductsResult?.items!!, null, 21)
                }
            }

        })
    }

    override fun loadBefore(params: PageKeyedDataSource.LoadParams<Long>,
                            callback: PageKeyedDataSource.LoadCallback<Long, ProductionItemBean>) {

    }

    override fun loadAfter(params: PageKeyedDataSource.LoadParams<Long>,
                           callback: PageKeyedDataSource.LoadCallback<Long, ProductionItemBean>) {
    }
}
