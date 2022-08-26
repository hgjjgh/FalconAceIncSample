package com.letsgo.myapplicationtest.network.service

import com.letsgo.myapplicationtest.network.service.response.NewsRes
import retrofit2.http.GET

interface NewsService {
    @GET(ApiPaths.PATH)
    suspend fun fetchNewsList(): NewsRes?
}