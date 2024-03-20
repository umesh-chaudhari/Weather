package com.umesh_app.weather.presentation.util

import java.time.LocalDateTime

object Constants {
    fun determineMap(
    ): Map<Int, String> {
        val newMap = mutableMapOf<Int, String>()
        newMap[0] = "Today"
        newMap[1] = "Tomorrow"
        val now = LocalDateTime.now()
        for (i in 2..6) {
            newMap[i] = now.plusDays(i.toLong()).dayOfWeek.toString().lowercase().replaceFirstChar {it.uppercase() }
        }
        return newMap
    }



}
