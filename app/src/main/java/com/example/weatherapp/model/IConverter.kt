package com.example.weatherapp.model

import android.annotation.SuppressLint
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
interface IConverter {

    fun toHour(datetime: Long): String{
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return Instant.ofEpochSecond(datetime).atZone(ZoneId.of("GMT-4")).format(formatter)
    }

    fun toDay(datetime: Long): String{
        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        return Instant.ofEpochSecond(datetime).atZone(ZoneId.of("GMT-4")).format(formatter)
    }

    fun toCelsius(F: Double?): Int{
        return ((F!! -32)/1.8000).toInt()
    }

}