package com.csf.sample

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.csf.paginglibrary.adapter.BaseQuickPagingAdapter
import com.csf.paginglibrary.adapter.BaseViewHolder

class FeedListAdapter :
    BaseQuickPagingAdapter<ProductionItemBean, BaseViewHolder>(R.layout.item_main, object :
        DiffUtil.ItemCallback<ProductionItemBean>() {
        override fun areItemsTheSame(oldItem: ProductionItemBean, newItem: ProductionItemBean): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(oldItem: ProductionItemBean, newItem: ProductionItemBean): Boolean {
            return oldItem == newItem
        }

    }) {

    override fun convert(holder: BaseViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(R.id.tv_test)
        textView.text = getItem(position)?.productName
    }
}
