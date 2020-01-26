package fr.zzi.androidarchitecture.feature.daylist.domain.contract

import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast

interface WeatherRepositoryInterface {

    suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double,
        dayNumber: Int
    ): List<DailyForecast>

}