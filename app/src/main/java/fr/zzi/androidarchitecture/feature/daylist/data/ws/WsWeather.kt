package fr.zzi.androidarchitecture.feature.daylist.data.ws

import fr.zzi.androidarchitecture.feature.daylist.domain.Weather

data class WsWeather(
    val icon: String?,
    val main: String?,
    val description: String?
) {
    fun convert(): Weather {
        return Weather(icon ?: "", main ?: "", description ?: "")
    }
}