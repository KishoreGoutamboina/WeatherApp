package com.example.weatherapplication.data.model

import com.squareup.moshi.Json

data class CurrentTemperatureResponse(
    @Json(name = "name")
    val cityName: String,
    @Json(name = "main")
    val currentTemperatureResponse: CurrentTemperatureResponseMain
)
