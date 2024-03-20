package com.umesh_app.weather.domain.repository

import com.umesh_app.weather.domain.util.Resource
import com.umesh_app.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(
        lat: Double,
        long: Double
    ): Resource<WeatherInfo>
}