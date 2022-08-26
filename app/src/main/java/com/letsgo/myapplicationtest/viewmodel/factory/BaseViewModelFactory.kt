package com.letsgo.myapplicationtest.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class BaseViewModelFactory(private val viewModel: ViewModel?) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel as? T ?: throw IllegalArgumentException("Unable to construct viewModel")
    }
}
