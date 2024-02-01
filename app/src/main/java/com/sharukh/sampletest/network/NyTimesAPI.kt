package com.sharukh.sampletest.network

import com.sharukh.sampletest.models.ApiResponse
import com.sharukh.sampletest.models.Docs
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface NyTimesAPI {

    @GET("svc/search/v2/articlesearch.json?q=election&api-key=j5GCulxBywG3lX211ZAPkAB8O381S5SM")
    fun articleList(): Single<ApiResponse<Docs>>
}

