package com.example.weatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.weatherapp.R
import com.example.weatherapp.data.service.response.WeatherResponse
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.mvp.contract.WeatherContract
import com.example.weatherapp.mvp.view.base.ActivityView

class WeatherView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity), WeatherContract.View {

    override fun showData(data: WeatherResponse) {
        Toast.makeText(context, R.string.data_received, Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(context, R.string.without_internet, Toast.LENGTH_SHORT).show()
    }
}
