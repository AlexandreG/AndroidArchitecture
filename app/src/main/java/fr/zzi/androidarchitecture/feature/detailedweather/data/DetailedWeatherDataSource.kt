package fr.zzi.androidarchitecture.feature.detailedweather.data

import fr.zzi.androidarchitecture.common.RestClient
import fr.zzi.androidarchitecture.feature.detailedweather.domain.HourlyForecastResult
import retrofit2.http.GET
import retrofit2.http.Query

object DetailedWeatherDataSource {

    private val retrofitService: RetrofitService

    init {
        retrofitService = RestClient.createService(RetrofitService::class.java)
    }

    suspend fun getForecast(
        cityLatitude: Double,
        cityLongitude: Double
    ): HourlyForecastResult {
        return retrofitService.getForecast(
            RestClient.API_KEY,
            RestClient.TEMPERATURE_UNIT,
            cityLatitude,
            cityLongitude
        )
    }

    interface RetrofitService {
        @GET("forecast/hourly")
        suspend fun getForecast(
            @Query("appid") apiKey: String?,
            @Query("units") temperatureUnit: String?,
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double
        ): HourlyForecastResult
    }

}