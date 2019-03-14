package com.example.weatherapp.model

class NextFiveDayWeather(): IConverter, IWeatherIcon {

    var description: String? = null
    var dayIcon: Int? = null
    var nightIcon: Int? = null
    var celsius: Int? = null
    var dayDate: String? = null
    var dayHour: String? = null

    constructor(datetime: Long, temperature: Double, description: String) : this(){

        this.description = description
        this.dayIcon = getDayImage(description)
        this.nightIcon = getNightImage(description)
        this.dayHour = toHour(datetime)
        this.dayDate = toDay(datetime)
        this.celsius = toCelsius(temperature)

    }

}