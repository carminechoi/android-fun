package com.example.practice.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.practice.R
import com.example.practice.weather.network.WeatherData

@Composable
fun WeatherScreen(
    vm: WeatherViewModel = WeatherViewModel()
) {
//    val current = vm.weatherData.current
//    val daily = vm.weatherData.daily
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.weatherColorPrimary))
            .wrapContentHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CurrentWeather()
        HourlyWeather()
        DailyWeather()
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    WeatherScreen()
}

@Composable
fun CurrentWeather() {
    Column(
        modifier = Modifier.padding(top = 90.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Los Angeles",
            fontSize = 24.sp,
            color = Color.White,
        )
        Row(
            modifier = Modifier.padding(0.dp)
        ) {
            Text(
                text = "\u00B0",
                fontSize = 72.sp,
                color = Color.Transparent,
            )
            Text(
                text = "58" + "\u00B0",
                fontSize = 72.sp,
                fontWeight = FontWeight.Thin,
                color = Color.White,
            )
        }
        Text(
            text = "Partly Cloudy",
            fontSize = 18.sp,
            color = Color.White,
        )
        Row() {
            Text(
                text ="H:72°",
                fontSize = 18.sp,
                color = Color.White,
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "L:49°",
                fontSize = 18.sp,
                color = Color.White,
            )
        }
    }
}

@Composable
fun HourlyWeather() {
    LazyRow (
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 10.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(colorResource(id = R.color.weatherColorSecondary)),
    ) {
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}
        item {HourlyWeatherItem()}

    }
}

@Composable
fun HourlyWeatherItem() {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "10PM",
            fontSize = 14.sp,
            color = Color.White,
        )
        Image(
            painter = rememberAsyncImagePainter("http://openweathermap.org/img/wn/" + "10d" +"@2x.png"),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Row() {
            Text(
                text = "\u00B0",
                fontSize = 18.sp,
                color = Color.Transparent,
            )
            Text(
                text = "58" + "\u00B0",
                fontSize = 18.sp,
                color = Color.White,
            )
        }
    }
}

@Composable
fun DailyWeather() {
    Column (
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 10.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(colorResource(id = R.color.weatherColorSecondary))
            .wrapContentHeight()
            .fillMaxSize(),
    ) {
        Text(
            text = "10-DAY FORECAST",
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
        )
        Divider(thickness = 0.6.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.6.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.8.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.6.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.8.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.6.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.8.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.6.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.8.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
        Divider(thickness = 0.6.dp, color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
        DailyWeatherItem()
    }
}

@Composable
fun DailyWeatherItem() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Today",
            fontSize = 18.sp,
            color = Color.White,
        )
        Image(
            painter = rememberAsyncImagePainter("http://openweathermap.org/img/wn/" + "10d" +"@2x.png"),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "L:58" + "\u00B0",
            fontSize = 18.sp,
            color = Color.White,
        )

        Text(
            text = "H:72" + "\u00B0",
            fontSize = 18.sp,
            color = Color.White,
        )
    }
}