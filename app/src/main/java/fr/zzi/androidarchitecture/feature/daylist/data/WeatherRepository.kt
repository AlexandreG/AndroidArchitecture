package fr.zzi.androidarchitecture.feature.daylist.data

import fr.zzi.androidarchitecture.feature.daylist.domain.ForecastResult
import fr.zzi.androidarchitecture.feature.daylist.domain.contract.WeatherRepositoryInterface

object WeatherRepository : WeatherRepositoryInterface {

    override suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double,
        dayNumber: Int
    ): ForecastResult {
        return WeatherDataSource.getForecast(
            cityLatitude,
            cityLongitude,
            dayNumber
        )
    }


}