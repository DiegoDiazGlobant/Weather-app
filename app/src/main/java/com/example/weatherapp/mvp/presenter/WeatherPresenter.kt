package com.example.weatherapp.mvp.presenter

import com.example.weatherapp.mvp.contract.WeatherContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherPresenter(
    private val model: WeatherContract.Model,
    private val view: WeatherContract.View
) : WeatherContract.Presenter {

    override fun getWeather() {
        model.getData(CITY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data -> view.showData(data) },
                { view.showError() })
    }

    companion object {
        private const val CITY = "Tandil"
    }
}
