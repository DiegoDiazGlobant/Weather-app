package com.example.weatherapp.data.service.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("dt_txt") val date: String,
    @SerializedName("main") val main: MainResponse
)
