package fr.zzi.androidarchitecture.feature.articlelist.ui

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.zzi.androidarchitecture.feature.articlelist.data.WeatherRepository
import fr.zzi.androidarchitecture.feature.articlelist.domain.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleListViewModel : ViewModel() {

    private val _articleLiveData = MutableLiveData<List<Article>>()
    val articleLiveData: LiveData<List<Article>> = _articleLiveData

    fun fetchArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            val articleResult = WeatherRepository.getArticles()

            _articleLiveData.postValue(
                filterArticles(articleResult.elements)
            )
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun filterArticles(articleList: List<Article>): List<Article> {
        return articleList.filter {
            !it.titre.isNullOrEmpty()
        }
    }

}