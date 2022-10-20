package com.example.practice.weather.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_WEATHER_URL = "https://api.openweathermap.org"
private const val WEATHER_API_KEY = "d70845e241920996a9611fa7304e4a24"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_WEATHER_URL)
    .build()

interface WeatherApiService {
    @GET("/data/3.0/onecall")
    suspend fun getWeather(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?,
        @Query("exclude") exclude: String?,
        @Query("units") units: String?,
        @Query("appid") appid: String = WEATHER_API_KEY,
    ): WeatherData
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}