package com.example.weatherapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.model.CurrentWeather
import com.example.weatherapp.model.NextFiveDayWeather
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.today_weather_hours.view.*

class CurrentWeatherAdapter(private val context: Context, private var weather: ArrayList<NextFiveDayWeather> ) :
        RecyclerView.Adapter<CurrentWeatherAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.today_weather_hours, parent, false))
    }

    override fun getItemCount(): Int {
        return weather.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(weather[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(weather: NextFiveDayWeather){
            itemView.todayWeatherCelsius.text = weather.celsius.toString() + "℃"
            itemView.todayWeatherHour.text = weather.dayHour
            Picasso.get()
                .load(weather.dayIcon!!.toInt())
                .placeholder(R.drawable.ic_location)
                .into(itemView.todayWeatherIcon)
        }
    }

}
