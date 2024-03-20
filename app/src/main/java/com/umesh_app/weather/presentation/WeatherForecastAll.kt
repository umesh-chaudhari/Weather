package com.umesh_app.weather.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.umesh_app.weather.presentation.ui.theme.DeepBlue
import com.umesh_app.weather.presentation.util.Constants

@Composable
fun WeatherForecastAll(
    state: WeatherState,
) {
    val dayMap = Constants.determineMap()
    val stateMap = state.weatherInfo?.weatherDataPerDay

    stateMap?.let { map ->
        LazyColumn(
        ) {
            items(map.keys.toList()) { index ->
                map[index]?.let { data ->
                    dayMap[index]?.let {
                        Text(
                            text = it,
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 16.dp)
                                .background(Color.Black)
                        )
                    }
                    LazyRow(
                    ) {
                        items(data) { weatherData ->
                            HourlyWeatherDisplay(
                                weatherData = weatherData,
                                modifier = Modifier
                                    .height(120.dp)
                                    .padding(horizontal = 16.dp, vertical = 16.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }

}