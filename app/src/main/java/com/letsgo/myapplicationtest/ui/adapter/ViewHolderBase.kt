package com.letsgo.myapplicationtest.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

data class ViewHolderBase(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)