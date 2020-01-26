package fr.zzi.androidarchitecture.feature.daylist.data.ws

import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast

data class WsForecastResult(
    val list: List<WsDailyForecast>
) {
    fun convert(): List<DailyForecast> {
        return list.map { it.convert() }
    }
}