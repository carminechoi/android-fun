package com.example.practice.weather

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.weather.network.*
import kotlinx.coroutines.launch

enum class WeatherApiStatus { LOADING, ERROR, DONE }

class WeatherViewModel : ViewModel() {
    private var _weatherData by mutableStateOf(WeatherData())
    val weatherData: WeatherData
        get() = _weatherData

    init {
        Log.i("init", "iniiiiiiit")
//        getWeatherData()
    }

    private fun getWeatherData() {
        viewModelScope.launch {
            try{
                _weatherData = WeatherApi.retrofitService.getWeather(
                    lat = 34.0536909,
                    lon = -118.242766,
                    exclude = "minutely, alerts",
                    units = "imperial",
                )
            } catch (e: Exception) {
                Log.e("weather vm", "inside error: " + e.message)
                _weatherData = WeatherData()
            }
        }
    }

//    private val _status = MutableLiveData<WeatherApiStatus>()
//    val status: LiveData<WeatherApiStatus> = _status
//    private val _weather = MutableLiveData<WeatherData>()
//    val weatherData: LiveData<WeatherData> = _weather
//
//    init {
//        getWeatherData()
//    }
//
//    private fun getWeatherData() {
//        viewModelScope.launch {
//            _status.value = WeatherApiStatus.LOADING
//            try {
//                Log.i("weather api", "before getWeather")
//                _weather.value = WeatherApi.retrofitService.getWeather(
//                    lat = 34.0536909,
//                    lon = -118.242766,
//                    exclude = "minutely, alerts",
//                    units = "imperial",
//                )
//                Log.i("weather api", "after getWeather: " + weatherData.value?.current?.temp.toString() ?: "no data")
//                _status.value = WeatherApiStatus.DONE
//            } catch (e: Exception) {
//                Log.e("weather api", "inside error: " + e.message)
//                _weather.value = WeatherData()
//                _status.value = WeatherApiStatus.ERROR
//            }
//        }
//    }
}