package com.csf.sample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.csf.paginglibrary.datasource.BasePageKeyDataSource
import com.csf.paginglibrary.datasource.BasePagingAdapterWrapper
import com.csf.paginglibrary.datasource.IPageKeyDataSource
import com.csf.sample.model.Article
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    var articleLiveData: LiveData<PagedList<Article>>? = null
        private set
    private val query = "movies"
    private val apiKey = "079dac74a5f94ebdb990ecf61c8854b7"
    private val initPage = 1L
    val compositeDisposable by lazy {
        CompositeDisposable()
    }
    private val pageDataSource = object :
        IPageKeyDataSource<Long, Article> {
        override fun loadInitial(
            params: PageKeyedDataSource.LoadInitialParams<Long>,
            callback: PageKeyedDataSource.LoadInitialCallback<Long, Article>
        ) {
            compositeDisposable.add(getFeed(initPage, params.requestedLoadSize).subscribe({
                callback.onResult(it, null, initPage + 1)
            }, {
                Log.e("FeedViewModel", it.message)
            }))
        }

        override fun loadAfter(
            params: PageKeyedDataSource.LoadParams<Long>,
            callback: PageKeyedDataSource.LoadCallback<Long, Article>
        ) {
            compositeDisposable.add(getFeed(params.key, params.requestedLoadSize).subscribe({
                callback.onResult(it, params.key + 1)
            }, {
                Log.e("FeedViewModel", it.message)
            }))
        }

        override fun loadBefore(
            params: PageKeyedDataSource.LoadParams<Long>,
            callback: PageKeyedDataSource.LoadCallback<Long, Article>
        ) {
            compositeDisposable.add(getFeed(params.key, params.requestedLoadSize).subscribe({
                callback.onResult(it, params.key - 1)
            }, {
                Log.e("FeedViewModel", it.message)
            }))
        }

    }
    init {
        init()
    }

    private fun init() {
        articleLiveData = BasePagingAdapterWrapper<Long, Article>()
            .setPageDataSource(BasePageKeyDataSource(pageDataSource))
            .dataSourceLiveData
    }

    private fun getFeed(pageIndex: Long, loadSize: Int): Observable<List<Article>> {
        return AppController.restApi.fetchFeed(
            query, apiKey, pageIndex, loadSize
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.articles }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}
