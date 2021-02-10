package com.example.weatherapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.data.service.WeatherService
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.mvp.WeatherContract
import com.example.weatherapp.mvp.model.WeatherModel
import com.example.weatherapp.mvp.presenter.WeatherPresenter
import com.example.weatherapp.mvp.view.WeatherView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = WeatherPresenter(WeatherModel(WeatherService()), WeatherView(this, binding))
        presenter.getWeather()
    }
}
