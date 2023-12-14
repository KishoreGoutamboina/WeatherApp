package com.example.weatherapplication.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.utils.Converters

class ForecastItemViewModel (
    private val averageTemp: Double,
    val day: String
    ) : ViewModel() {

        val temperature: Int by lazy {
            setTemperature()
        }

        private fun setTemperature(): Int {
            return Converters.kelvinToCelsius(averageTemp)
        }
}