package com.example.weatherapplication.data.model

import com.squareup.moshi.Json

data class ForecastResponse(
    @Json(name = "list")
    val forecastList: List<IndividualForecastResponse>
)
