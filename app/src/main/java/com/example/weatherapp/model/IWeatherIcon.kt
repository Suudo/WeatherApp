package com.example.weatherapp.model

import com.example.weatherapp.R

interface IWeatherIcon {
    fun getDayImage(description: String?) : Int{
        when(description){
            "clear sky" -> return R.drawable.day_clear_sky
            "few clouds" -> return R.drawable.day_few_clouds
            "scattered clouds" -> return R.drawable.scattered_clouds
            "broken clouds" -> return R.drawable.broken_clouds
            "shower rain" -> return R.drawable.shower_rain
            "rain" -> return R.drawable.day_rain
            "light rain" -> return R.drawable.day_rain
            "thunderstorm" -> return R.drawable.thunderstorm
            "snow" -> return R.drawable.snow
            "mist" -> return R.drawable.mist
        }
        return 0
    }

    fun getNightImage(description: String) : Int{
        when(description){
            "clear sky" -> return R.drawable.night_clear_sky
            "few clouds" -> return R.drawable.night_few_clouds
            "scattered clouds" -> return R.drawable.scattered_clouds
            "broken clouds" -> return R.drawable.broken_clouds
            "shower rain" -> return R.drawable.shower_rain
            "rain" -> return R.drawable.night_rain
            "light rain" -> return R.drawable.night_rain
            "thunderstorm" -> return R.drawable.thunderstorm
            "snow" -> return R.drawable.snow
            "mist" -> return R.drawable.mist
        }
        return 0
    }
}