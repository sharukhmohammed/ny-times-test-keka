package com.sharukh.sampletest.network

import com.sharukh.sampletest.models.ApiResponse
import com.sharukh.sampletest.models.Docs
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal class APIService {

    private val gitHubApi: NyTimesAPI

    init {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

        gitHubApi = retrofit.create(NyTimesAPI::class.java)
    }


    fun getListArticles(): Single<ApiResponse<Docs>> {
        return gitHubApi.articleList()
    }


    companion object {
        const val BASE_URL = "https://api.nytimes.com"
        const val BASE_URL_IMG = "https://static01.nyt.com/"
    }
}