package fr.zzi.androidarchitecture.feature.daylist.data.room

import fr.zzi.androidarchitecture.common.AppDatabase
import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast

object RoomWeatherDataSource {
    suspend fun getForecast(): List<DailyForecast> {
        return AppDatabase.getInstance().getDailyForecastDao().getAll().map {
            it.convert()
        }
    }

    suspend fun save(forecastList: List<DailyForecast>) {
        AppDatabase.getInstance().getDailyForecastDao().insertAll(forecastList.map {
            DbDailyForecast.convert(it)
        })
    }

}