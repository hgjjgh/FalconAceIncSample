package com.letsgo.myapplicationtest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.letsgo.myapplicationtest.callBack.NewsItemClick
import com.letsgo.myapplicationtest.common.CommonConfig
import com.letsgo.myapplicationtest.databinding.NewsHeaderBinding
import com.letsgo.myapplicationtest.databinding.NewsItemBinding
import com.letsgo.myapplicationtest.network.service.response.Item

const val HEADER = 0
const val CONTENT = 1

class NewsAdapter(private val newsList: List<Item>?, private val callBack: NewsItemClick) :
    RecyclerView.Adapter<ViewHolderBase>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBase {
        val binding = when (viewType) {
            HEADER -> {
                NewsHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }
            else -> {
                NewsItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }
        }
        return ViewHolderBase(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderBase, position: Int) {
        val binding = holder.binding
        val bean = newsList?.get(position)

        when (binding) {
            is NewsHeaderBinding -> {
                binding.title = bean?.title ?: ""
            }
            is NewsItemBinding -> {
                binding.bean = bean
                binding.itemClick = callBack
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (newsList?.get(position)?.type) {
            CommonConfig.NEWS_TYPE_DRIVER -> {
                HEADER
            }
            else -> {
                CONTENT
            }
        }
    }
}