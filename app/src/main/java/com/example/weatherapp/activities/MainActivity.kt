package com.example.weatherapp.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.weatherapp.DTO.ListWeather
import com.example.weatherapp.DTO.MainWeather
import com.example.weatherapp.GetWeatherService
import com.example.weatherapp.R
import com.example.weatherapp.RetrofitClientInstance
import com.example.weatherapp.adapter.CurrentWeatherAdapter
import com.example.weatherapp.adapter.NextFiveDayAdapter
import com.example.weatherapp.model.CurrentWeather
import com.example.weatherapp.model.IWeatherIcon
import com.example.weatherapp.model.NextFiveDayWeather
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.today_weather_hours.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), IWeatherIcon {

    var weatherArray: ArrayList<NextFiveDayWeather> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClientInstance.retrofitInstance!!.create(GetWeatherService::class.java)

        // Service 1

        service.getCurrentWeather().enqueue(object: Callback<MainWeather>{
            override fun onFailure(call: Call<MainWeather>, t: Throwable) {
            }

            override fun onResponse(call: Call<MainWeather>, response: Response<MainWeather>) {
                val weather = response.body()
                val currentWeather = CurrentWeather(
                    weather!!.main.temp,
                    weather.weather[0].description,
                    weather.name,
                    weather.weather[0].main
                )
                updateCurrentWeatherUI(currentWeather)
            }
        })

        service.getAllWeather().enqueue(object: Callback<ListWeather>{
            override fun onFailure(call: Call<ListWeather>, t: Throwable) {
            }

            override fun onResponse(call: Call<ListWeather>, response: Response<ListWeather>) {
                val weather = response.body()!!.list

                for(item in weather){
                    val weatherList = NextFiveDayWeather(
                        item.dt,
                        item.main.temp,
                        item.weather[0].description
                    )
                    weatherArray.add(weatherList)
                    updateUI(weatherArray)

                }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    fun updateCurrentWeatherUI(weather: CurrentWeather){
        currentWeatherCelsius.text = weather.celsius.toString() + "℃"
        currentWeatherDescription.text = weather.description
        currentWeatherCityName.text = weather.name
        Picasso.get()
            .load(getDayImage(weather.description!!))
            .placeholder(R.drawable.ic_location)
            .into(currentWeatherIcon)

    }

    @SuppressLint("SimpleDateFormat")
    fun updateUI(weatherList: ArrayList<NextFiveDayWeather>){

        for(item in weatherList){
            Log.d("Descriptions->>>", item.description)
        }

        val day = weatherList.filter{it.dayHour == "11:00"} as ArrayList
        val night = weatherList.filter{it.dayHour == "23:00"} as ArrayList
        val toDayWeatherList = weatherList.filter{it.dayDate == SimpleDateFormat("dd MMMM").format(Calendar.getInstance().time)} as ArrayList

        nextFiveDayRV.layoutManager = LinearLayoutManager(this)
        nextFiveDayRV.adapter = NextFiveDayAdapter(this, day, night)

        nextHourRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        nextHourRV.adapter = CurrentWeatherAdapter(this, toDayWeatherList)

    }
}
