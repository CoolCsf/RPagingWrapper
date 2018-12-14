package com.csf.sample

import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class FeedListAdapter : PagedListAdapter<ProductionItemBean, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<ProductionItemBean>() {
    override fun areItemsTheSame(oldItem: ProductionItemBean, newItem: ProductionItemBean): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: ProductionItemBean, newItem: ProductionItemBean): Boolean {
        return oldItem == newItem
    }

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleItemViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ArticleItemViewHolder) {
        }
    }

    inner class ArticleItemViewHolder(view: TextView) : RecyclerView.ViewHolder(view)


}
