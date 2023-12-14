package com.example.weatherapplication.data.repository

import com.example.weatherapplication.data.api.NetworkService
import com.example.weatherapplication.data.model.CurrentTemperatureResponse
import com.example.weatherapplication.data.model.ForecastResponse
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val networkService: NetworkService) {

    suspend fun getCurrentTemperature(cityName: String): Response<CurrentTemperatureResponse> {
        return networkService.getCurrentTemperature(cityName)
    }

    suspend fun getForecast(cityName: String): Response<ForecastResponse> {
        return networkService.getForecast(cityName)
    }
}
