package fr.zzi.androidarchitecture.feature.daylist.data

import fr.zzi.androidarchitecture.common.RestClient
import fr.zzi.androidarchitecture.feature.daylist.domain.ForecastResult
import retrofit2.http.GET
import retrofit2.http.Query

object WeatherDataSource {

    private val retrofitService: RetrofitService

    init {
        retrofitService = RestClient.createService(RetrofitService::class.java)
    }

    suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double,
        dayNumber: Int
    ): ForecastResult {
        return retrofitService.getForecast(
            RestClient.API_KEY,
            RestClient.TEMPERATURE_UNIT,
            cityLatitude,
            cityLongitude,
            dayNumber
        )
    }

    interface RetrofitService {
        @GET("forecast/daily")
        suspend fun getForecast(
            @Query("appid") apiKey: String?,
            @Query("units") temperatureUnit: String?,
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double,
            @Query("cnt") dayNumber: Int
        ): ForecastResult
    }

}