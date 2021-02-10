package com.example.weatherapp.data.service

import com.example.weatherapp.data.service.api.WeatherApi
import com.example.weatherapp.data.service.request.generator.WeatherRequestGenerator
import com.example.weatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()

    fun getWeatherByCityName(city: String): Observable<WeatherResponse> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(WeatherApi::class.java).getWeatherData(city, API_KEY, METRIC)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let { subscriber.onNext(it) }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val API_KEY = "027b7152f20f23f8f0cbc9f4bfab880c"
        private const val METRIC = "metric"
    }
}
