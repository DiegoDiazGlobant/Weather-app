package com.example.weatherapp.data.service.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list") val list: List<DataResponse>,
)
