package com.example.practice.weather.network

import com.squareup.moshi.Json

data class WeatherData (
    @Json(name = "current") val current: Current = Current(),
    @Json(name = "hourly") val hourly: List<Hourly> = listOf(),
    @Json(name = "daily") val daily: List<Daily> = listOf(),
)

data class Current (
    @Json(name = "dt") val datetime: Int = 0,
    @Json(name = "temp") val temp: Double = 0.0,
    @Json(name = "weather") val weather: List<Weather> = listOf(),
)

data class Daily (
    @Json(name = "dt") val datetime: Int = 0,
    @Json(name = "temp") val temp: Temp = Temp(),
    @Json(name = "weather") val weather: List<Weather> = listOf(),
)

data class Hourly (
    @Json(name = "dt") val datetime: Int = 0,
    @Json(name = "temp") val temp: Double = 0.0,
    @Json(name = "weather") val weather: List<Weather> = listOf(),
)

data class Weather (
    @Json(name = "description") val description: String = "",
    @Json(name = "icon") val icon: String = "",
)

data class Temp (
    @Json(name = "day") val day: Double = 0.0,
    @Json(name = "min") val min: Double = 0.0,
    @Json(name = "max") val max: Double = 0.0,
)

