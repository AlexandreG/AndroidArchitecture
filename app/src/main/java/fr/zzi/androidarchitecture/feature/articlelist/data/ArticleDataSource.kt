package fr.zzi.androidarchitecture.feature.articlelist.data

import fr.zzi.androidarchitecture.common.RestClient
import fr.zzi.androidarchitecture.feature.articlelist.domain.ArticleResult
import retrofit2.http.GET

object ArticleDataSource {

    private val retrofitService: RetrofitService

    init {
        retrofitService = RestClient.createService(RetrofitService::class.java)
    }

    suspend fun getArticles(): ArticleResult {
        return retrofitService.getArticles()
    }

    interface RetrofitService {
        @GET("en_continu/index.json")
        suspend fun getArticles(): ArticleResult
    }

}