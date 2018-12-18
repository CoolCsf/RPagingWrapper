# 基于Paging封装的库

### 简介

建议优先看下paging的使用方式和简介，连接如下：https://developer.android.com/topic/libraries/architecture/paging/  请自备梯子。中文文档现在也比较多了，请自行上搜索引擎搜索。本文不着重介绍paging的基本使用技巧，后期考虑单独出一篇介绍Paging的使用技巧

设计初衷：根据官方设计，Paging解耦了数据层与UI层，让数据与UI更加分离，分页加载逻辑更加高内聚，完美地帮我们封装了分页加载逻辑，提供了如丝般顺滑的体验。但是，也出现了新的问题：为了解耦，导致了实现一个分页加载的功能需要多写几个类（如DataSource，DataSourceFactory等），异常麻烦。基于这层考虑，故封装了此库，让你可以更简单去实现如丝般顺滑的分页。

### 使用方式

#### 数据部分

1. 获得liveData

   ```kotlin
   var articleLiveData: LiveData<PagedList<Article>>? = null
        private set
   
   articleLiveData = BasePagingAdapterWrapper<Long, Article>()
            .setPageDataSource(BasePageKeyDataSource(pageDataSoure))
            .dataSourceLiveData
   
   ```

2. 创建DataSource，这里以PageKeyDataSource为例，剩下的ItemKeyDataSource和PositionalDataSource也提供了对应的Api，使用方法大同小异：

   ```kotlin
   private val pageDataSoure = object :
       IPageKeyDataSource<Long, Article> {
       override fun loadInitial(
           params: PageKeyedDataSource.LoadInitialParams&lt;Long&gt;,
           callback: PageKeyedDataSource.LoadInitialCallback&lt;Long, Article&gt;
       ) {
           compositeDisposable.add(getFeed(initPage, params.requestedLoadSize).subscribe({
               //请不要忘了在获取到数据后，对结果进行callBack
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
               //请不要忘了在获取到数据后，对结果进行callBack
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
               //请不要忘了在获取到数据后，对结果进行callBack
               callback.onResult(it, params.key - 1)
           }, {
               Log.e("FeedViewModel", it.message)
           }))
       }
   
   } 
   ```

3. 当然，你需要有自己获取数据的方式，我这里用网络获取的方式，采用retrofit+rxjava2，你可以采用本地数据库or你自己的数据获取方式，注意在onSuccess的时候进行callback！！！详情看步骤2。

   ```kotlin
      //此步骤只是为了获取到数据，与本库无关，只是为了提供步骤2的getFeed方法。
      private fun getFeed(pageIndex: Long, loadSize: Int): Observable<List<Article>> {
          return AppController.restApi.fetchFeed(
              query, apiKey, pageIndex, loadSize
          ).subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .map { it.articles }
      }
   ```

4. 在Activity中与RecycleView和Adapter的使用

   ```kotlin
   val feedViewModel = FeedViewModel()
   rv_test.layoutManager = LinearLayoutManager(this)
   val adapter = FeedListAdapter()
   feedViewModel.articleLiveData?.observe(
               this,
               Observer<PagedList<Article>> { adapter.submitList(it) })
   rv_test.adapter = adapter
   ```

#### UI部分

Adapter可以自己继承PageListAdapter进行实现或任何其他拓展了PageListAdapter的第三方adapter，在本库中也提供了BaseQuickPagingAdapter，目前比较简陋，后续会继续实现和维护。BaseQuickPagingAdapter的使用方式：

```kotlin
class FeedListAdapter :
    BaseQuickPagingAdapter<Article, BaseViewHolder>(R.layout.item_main, object :
        DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun convert(holder: BaseViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.tv_test)
        textView.text = getItem(position)?.title
    }
}
```