package com.example.weatherapp.mvp.view

import android.app.Activity
import com.example.weatherapp.R
import com.example.weatherapp.data.service.response.WeatherResponse
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.mvp.WeatherContract

class WeatherView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity), WeatherContract.View {

    override fun showData(data: WeatherResponse) {
        binding.textScreen.text = context?.getString(R.string.data_received).toString()
    }
}
