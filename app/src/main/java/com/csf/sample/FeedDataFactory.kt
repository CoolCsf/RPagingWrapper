package com.csf.sample

import androidx.paging.DataSource

class FeedDataFactory() : DataSource.Factory<Long, ProductionItemBean>() {

    override fun create(): DataSource<Long, ProductionItemBean> {
        return FeedDataSource()
    }

}
