package fr.zzi.androidarchitecture.feature.articlelist.data

import fr.zzi.androidarchitecture.feature.articlelist.domain.ArticleResult
import fr.zzi.androidarchitecture.feature.articlelist.domain.contract.ArticleRepositoryInterface

object WeatherRepository : ArticleRepositoryInterface {

    override suspend fun getArticles(): ArticleResult {
        return ArticleDataSource.getArticles()
    }


}