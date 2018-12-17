package com.csf.sample

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.csf.paginglibrary.adapter.BaseQuickPagingAdapter
import com.csf.paginglibrary.adapter.BaseViewHolder
import com.csf.sample.model.Article

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
