package com.sharukh.sampletest.searchlist

import com.sharukh.sampletest.models.ApiResponse
import com.sharukh.sampletest.network.APIService

class SearchListRepo {
    private val api = APIService()

    fun getArticleList() = api.getListArticles()
}