package fr.zzi.androidarchitecture.feature.detailedweather.domain.contract

import fr.zzi.androidarchitecture.feature.detailedweather.domain.HourlyForecastResult

interface DetailedWeatherRepositoryInterface {

    suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double
    ): HourlyForecastResult

}