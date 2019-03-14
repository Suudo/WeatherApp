package com.example.weatherapp

import com.example.weatherapp.DTO.ListWeather
import com.example.weatherapp.DTO.MainWeather
import retrofit2.Call
import retrofit2.http.GET

interface GetWeatherService {
    @GET("/data/2.5/forecast?q=London&amp&APPID=ed37551430f18ffc641b2ae084751b5f&units=imperial")
    fun getAllWeather(): Call<ListWeather>

    @GET("/data/2.5/weather?q=London&APPID=ed37551430f18ffc641b2ae084751b5f&units=imperial")
    fun getCurrentWeather(): Call<MainWeather>

}