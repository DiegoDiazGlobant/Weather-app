package com.example.weatherapp.mvp.model

import com.example.weatherapp.data.service.WeatherService
import com.example.weatherapp.data.service.response.WeatherResponse
import com.example.weatherapp.mvp.WeatherContract
import io.reactivex.rxjava3.core.Observable

class WeatherModel(private val weatherService: WeatherService) : WeatherContract.Model {

    override fun getData(city: String): Observable<WeatherResponse> =
        weatherService.getWeatherByCityName(city)
}
