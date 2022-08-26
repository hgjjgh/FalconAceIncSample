package com.letsgo.myapplicationtest.viewmodel

import androidx.lifecycle.viewModelScope
import com.letsgo.myapplicationtest.common.SingleLiveEvent
import com.letsgo.myapplicationtest.network.repository.NewsRepository
import com.letsgo.myapplicationtest.network.service.response.Item
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val newsRepository: NewsRepository) : BaseViewModel() {
    val newsList = SingleLiveEvent< List<Item>?>()

    fun getNewsList() {
        viewModelScope.launch {
            newsRepository.fetchNewsList()
                .onStart {
                    showLoading.postValue(true)
                }
                .catch { exception ->
                    apiErrorMessage.postValue(exception.message)
                }
                .onCompletion {
                    showLoading.postValue(false)
                }
                .collect { res ->
                    newsList.postValue(res)
                }
        }
    }
}