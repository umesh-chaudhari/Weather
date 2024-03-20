package com.umesh_app.weather.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressureLevel: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)