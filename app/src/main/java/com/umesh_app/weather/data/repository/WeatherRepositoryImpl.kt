package com.umesh_app.weather.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.umesh_app.weather.data.mappers.toWeatherInfo
import com.umesh_app.weather.data.remote.WeatherApi
import com.umesh_app.weather.domain.repository.WeatherRepository
import com.umesh_app.weather.domain.util.Resource
import com.umesh_app.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An Unknown Error Occured.")
        }
    }
}