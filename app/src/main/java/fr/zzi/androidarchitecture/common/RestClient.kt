package fr.zzi.androidarchitecture.common

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private const val URL = "https://api.openweathermap.org/data/2.5/"
    const val API_KEY = "e373fbdfb7c805a59762e6388e9ede6b"
    const val TEMPERATURE_UNIT = "metric"

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}