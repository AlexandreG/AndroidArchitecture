package fr.zzi.androidarchitecture.feature.daylist.data

import fr.zzi.androidarchitecture.feature.daylist.data.room.RoomWeatherDataSource
import fr.zzi.androidarchitecture.feature.daylist.data.ws.WsWeatherDataSource
import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast
import fr.zzi.androidarchitecture.feature.daylist.domain.contract.WeatherRepositoryInterface

object WeatherRepository : WeatherRepositoryInterface {

    override suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double,
        dayNumber: Int
    ): List<DailyForecast> {
        var forecastList = emptyList<DailyForecast>()
        try {
            forecastList = WsWeatherDataSource.getForecast(
                cityLatitude,
                cityLongitude,
                dayNumber
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (forecastList.isEmpty()) {
            forecastList = RoomWeatherDataSource.getForecast()
        } else {
            RoomWeatherDataSource.save(forecastList)
        }

        return forecastList
    }


}