package com.example.weatherapplication.data.model

import com.squareup.moshi.Json

data class IndividualForecastResponse(
    @Json(name = "main")
    val currentTemperatureMain: CurrentTemperatureResponseMain,
    @Json(name = "dt_txt")
    val dateAndTime: String
)
