package fr.zzi.androidarchitecture.feature.detailedweather.data

import fr.zzi.androidarchitecture.feature.detailedweather.domain.HourlyForecastResult
import fr.zzi.androidarchitecture.feature.detailedweather.domain.contract.DetailedWeatherRepositoryInterface

object DetailedWeatherRepository : DetailedWeatherRepositoryInterface {

    override suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double
    ): HourlyForecastResult {
        return DetailedWeatherDataSource.getForecast(
            cityLatitude,
            cityLongitude
        )
    }


}