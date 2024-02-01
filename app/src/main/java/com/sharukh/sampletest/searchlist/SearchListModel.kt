package com.sharukh.sampletest.searchlist

import com.sharukh.sampletest.models.Doc
import com.sharukh.sampletest.network.APIService
import io.reactivex.rxjava3.core.Single

class SearchListModel {
    private val searchListRepo = SearchListRepo()

    fun getArticleList(): Single<List<Doc>> {
        return searchListRepo
            .getArticleList()
            .map {
                // Map the Data
                if (it.response != null)
                    it.response!!.docs
                else
                    throw Error("Null Reponse")
            }
            .map {
                // Set the image URLs
                it.map { doc ->
                    doc.image?.url = "${BASE_IMG}${doc.image?.url}"
                    doc
                }
            }

    }

    companion object {
        const val BASE_IMG = APIService.BASE_URL_IMG
    }

}