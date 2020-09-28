package fr.zzi.androidarchitecture.feature.articlelist.domain.contract

import fr.zzi.androidarchitecture.feature.articlelist.domain.ArticleResult

interface ArticleRepositoryInterface {

    suspend fun getArticles(): ArticleResult

}