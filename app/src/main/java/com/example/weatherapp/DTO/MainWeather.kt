package com.example.weatherapp.DTO

data class MainWeather (
    var dt: Long,
    var main: MainDTO,
    var weather: List<WeatherDTO>,
    var dt_txt: String,
    var name: String
)
