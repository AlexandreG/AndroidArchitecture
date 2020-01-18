package fr.zzi.androidarchitecture.feature.daylist.domain.contract

import fr.zzi.androidarchitecture.feature.daylist.domain.ForecastResult

interface WeatherRepositoryInterface {

    suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double,
        dayNumber: Int
    ): ForecastResult

}