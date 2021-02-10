package com.example.weatherapp.mvp

import com.example.weatherapp.data.service.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherContract {

    interface Model {
        fun getData(city: String): Observable<WeatherResponse>
    }

    interface Presenter {
        fun getWeather()
    }

    interface View {
        fun showData(data: WeatherResponse)
    }
}
