package fr.zzi.androidarchitecture.feature.daylist.domain

data class DailyForecast(
    val weather: List<Weather>,
    var dt: Long = 0
)