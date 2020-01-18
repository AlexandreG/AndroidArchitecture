package fr.zzi.androidarchitecture.feature.daylist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.zzi.androidarchitecture.feature.daylist.data.WeatherRepository
import fr.zzi.androidarchitecture.feature.daylist.domain.ForecastResult
import kotlinx.coroutines.*

class DayListViewModel : ViewModel(), CoroutineScope by MainScope() {

    companion object {
        const val CITY_LATITUDE = 47.2260781
        const val CITY_LONGITUDE = -1.6218336
        const val NB_FORECAST_DAY = 5
    }

    fun getForecast(): LiveData<ForecastResult> {
        val result = MutableLiveData<ForecastResult>()

        launch(Dispatchers.IO) {
            result.postValue(
                WeatherRepository.getForecast(
                    CITY_LATITUDE,
                    CITY_LONGITUDE,
                    NB_FORECAST_DAY
                )
            )
        }

        return result
    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }
}