package com.example.weatherapp.data.service

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.service.api.WeatherApi
import com.example.weatherapp.data.service.request.generator.WeatherRequestGenerator
import com.example.weatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()

    fun getWeatherByCityName(city: String): Observable<WeatherResponse> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(WeatherApi::class.java).getWeatherData(city, BuildConfig.API_KEY, METRIC)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let { subscriber.onNext(it) }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val METRIC = "metric"
    }
}
