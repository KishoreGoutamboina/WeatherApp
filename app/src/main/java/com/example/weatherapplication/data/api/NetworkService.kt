package com.example.weatherapplication.data.api

import com.example.weatherapplication.data.model.CurrentTemperatureResponse
import com.example.weatherapplication.data.model.ForecastResponse
import com.example.weatherapplication.utils.Constants.WEATHER_API_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("weather")
    suspend fun getCurrentTemperature(
        @Query("q") city_name: String,
        @Query("APPID") api_key: String = WEATHER_API_ID
    ): Response<CurrentTemperatureResponse>

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city_name: String,
        @Query("APPID") api_key: String = WEATHER_API_ID
    ): Response<ForecastResponse>
}