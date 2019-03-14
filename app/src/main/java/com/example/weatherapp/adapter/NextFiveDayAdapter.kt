package com.example.weatherapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.model.NextFiveDayWeather
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.next_five_day.view.*

class NextFiveDayAdapter(private val context: Context, private var day: ArrayList<NextFiveDayWeather>,
                         private var night: ArrayList<NextFiveDayWeather>) :
        RecyclerView.Adapter<NextFiveDayAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.next_five_day, parent, false))
    }

    override fun getItemCount(): Int {
        return day.size or night.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(day[position], night[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(weatherDay: NextFiveDayWeather, weatherNight: NextFiveDayWeather){
            itemView.nextFiveDayDate.text = weatherDay.dayDate
            itemView.nextFiveDayCelsius.text = weatherDay.celsius.toString() + "℃"
            itemView.nextFiveNightCelsius.text = weatherNight.celsius.toString() + "℃"
            Picasso.get()
                .load(weatherDay.dayIcon!!.toInt())
                .placeholder(R.drawable.ic_location)
                .into(itemView.nextFiveDayIcon)

            Picasso.get()
                .load(weatherNight.nightIcon!!.toInt())
                .placeholder(R.drawable.ic_location)
                .into(itemView.nextFiveNightIcon)
        }
    }

}
