package com.example.weatherapp.DTO

import com.google.gson.annotations.SerializedName

data class ListWeather (@SerializedName("list") var list: List<MainWeather>)
