package com.example.weatherapp.model

class CurrentWeather(): IConverter, IWeatherIcon {
    var celsius: Int? = null
    var icon: Int? = null
    var description: String? = null
    var name: String? = null
    var main: String? = null

    constructor(temperature: Double?,description: String?, name: String?, main: String?) : this(){
        this.celsius = toCelsius(temperature)
        this.icon = getDayImage(description)
        this.description = description
        this.name = name
        this.main = main
    }
}