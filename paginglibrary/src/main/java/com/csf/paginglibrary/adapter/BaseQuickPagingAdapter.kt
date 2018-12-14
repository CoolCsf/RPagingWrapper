package com.csf.paginglibrary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import java.lang.IllegalArgumentException

abstract class BaseQuickPagingAdapter<DATA, VH : BaseViewHolder>(
    private val resourceId: Int,
    diffCallBack: DiffUtil.ItemCallback<DATA>
) : PagedListAdapter<DATA, VH>(diffCallBack) {
    var mItemClickListener: IClickListener? = null

    init {
        if (resourceId == 0) {
            throw IllegalArgumentException("please set resourceId")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(resourceId, parent, false)
        @Suppress("UNCHECKED_CAST")
        val holder = BaseViewHolder(view) as VH
        mItemClickListener?.onItemClickListener(this, holder, holder.layoutPosition)
        return holder
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        convert(holder, position)
    }

    abstract fun convert(holder: VH, position: Int)
    interface IClickListener {
        fun <VH> onItemClickListener(adapter: BaseQuickPagingAdapter<*, *>, holder: VH, position: Int)
    }
}