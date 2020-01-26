package fr.zzi.androidarchitecture.feature.daylist.data.ws

import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast

data class WsDailyForecast(
    val weather: List<WsWeather>?,
    var dt: Long?
) {
    fun convert(): DailyForecast {
        return DailyForecast(weather?.map { it.convert() } ?: listOf(), dt ?: 0)
    }
}