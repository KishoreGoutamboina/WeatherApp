package com.example.weatherapplication.data.model

import com.squareup.moshi.Json

data class CurrentTemperatureResponseMain(
    @Json(name = "temp")
    val temperature: Double,
)
