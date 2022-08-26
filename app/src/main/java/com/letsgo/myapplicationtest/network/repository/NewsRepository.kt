package com.letsgo.myapplicationtest.network.repository

import com.letsgo.myapplicationtest.common.CommonConfig
import com.letsgo.myapplicationtest.network.service.ApiClient
import com.letsgo.myapplicationtest.network.service.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository {
    private val newsService: NewsService by lazy {
        ApiClient.apiService
    }

    suspend fun fetchNewsList() = flow {
        val res = newsService.fetchNewsList()

        val typeData = res?.getVector?.items?.filter {
            it.type == CommonConfig.NEWS_TYPE_DRIVER ||
                    it.type == CommonConfig.NEWS_TYPE_NEWS
        }

        val result = typeData?.filterNot { item ->
            var saveData = false

            if (item.type == CommonConfig.NEWS_TYPE_DRIVER) {
                for (i in typeData.indices) {
                    val bean = typeData[i]

                    if (bean.type == CommonConfig.NEWS_TYPE_NEWS &&
                        item.meta?.section == bean.meta?.section) {
                        saveData = true
                        break
                    }
                }
            }

            item.type == CommonConfig.NEWS_TYPE_DRIVER && !saveData
        }

        emit(result)
    }.flowOn(Dispatchers.IO)
}