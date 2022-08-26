package com.letsgo.myapplicationtest.network.repository

import com.letsgo.myapplicationtest.common.CommonConfig
import com.letsgo.myapplicationtest.network.service.ApiClient
import com.letsgo.myapplicationtest.network.service.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class NewsRepository {
    private val newsService: NewsService by lazy {
        ApiClient.apiService
    }

    suspend fun fetchNewsList() = flow {
        val res = newsService.fetchNewsList()
        val data = res?.getVector?.items?.filter {
            it.type == CommonConfig.NEWS_TYPE_DRIVER ||
                    it.type == CommonConfig.NEWS_TYPE_NEWS
        }
        emit(data)
    }.flowOn(Dispatchers.IO)
}