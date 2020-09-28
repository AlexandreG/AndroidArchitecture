package fr.zzi.androidarchitecture.articlelist

import fr.zzi.androidarchitecture.feature.articlelist.domain.Article
import fr.zzi.androidarchitecture.feature.articlelist.ui.ArticleListViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ArticleListViewModelTest {

    lateinit var viewModel: ArticleListViewModel

    @Before
    fun setup() {
        viewModel = ArticleListViewModel()
    }

    @Test
    fun `empty title is removed`() {
        val articlesToFilter = listOf(
            Article("Titre1"),
            Article("Titre2"),
            Article("Titre3"),
            Article("")
        )
        val articlesFiltered = listOf(
            Article("Titre1"),
            Article("Titre2"),
            Article("Titre3")
        )

        Assert.assertEquals(articlesFiltered, viewModel.filterArticles(articlesToFilter))
    }

}