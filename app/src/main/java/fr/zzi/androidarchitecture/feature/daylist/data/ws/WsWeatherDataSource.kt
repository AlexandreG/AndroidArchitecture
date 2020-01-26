package fr.zzi.androidarchitecture.feature.daylist.data.ws

import fr.zzi.androidarchitecture.common.RestClient
import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast
import retrofit2.http.GET
import retrofit2.http.Query

object WsWeatherDataSource {

    private val retrofitService: RetrofitService

    init {
        retrofitService = RestClient.createService(
            RetrofitService::class.java
        )
    }

    suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double,
        dayNumber: Int
    ): List<DailyForecast> {
        return retrofitService.getForecast(
            RestClient.API_KEY,
            RestClient.TEMPERATURE_UNIT,
            cityLatitude,
            cityLongitude,
            dayNumber
        ).convert()
    }

    interface RetrofitService {
        @GET("forecast/daily")
        suspend fun getForecast(
            @Query("appid") apiKey: String,
            @Query("units") temperatureUnit: String,
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double,
            @Query("cnt") dayNumber: Int
        ): WsForecastResult
    }

}