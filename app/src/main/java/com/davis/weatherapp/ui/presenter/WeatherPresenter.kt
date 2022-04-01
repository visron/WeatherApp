package com.davis.weatherapp.ui.presenter

import com.davis.weatherapp.core.ResponseListener
import com.davis.weatherapp.model.dbmodels.CurrentWeatherEntity
import com.davis.weatherapp.model.dbmodels.ForecastEntity
import com.davis.weatherapp.ui.model.WeatherModel
import com.davis.weatherapp.ui.view.WeatherContract

class WeatherPresenter(var view: WeatherContract.view, var model: WeatherModel) :
    WeatherContract.presenter {
    override fun onDestroy() {}
    override fun requestWeather(latitude: String, longitude: String) {
        view.onShowLoading()
        var responseListener = object : ResponseListener {
            override fun onSuccess(jsonObject: Any?) {
                view.onHideLoading()
                view.onWeatherLoaded(jsonObject as CurrentWeatherEntity)
            }

            override fun onError(jsonObject: String?) {
                view.onHideLoading()
                view.onError(jsonObject!!)
            }
        }
        model.loadWeather(latitude, longitude, responseListener)
    }

    override fun requestForecast(latitude: String, longitude: String) {
        view.onShowLoading()
        var responseListener = object : ResponseListener {
            override fun onSuccess(jsonObject: Any?) {
                view.onHideLoading()
                view.onForecastLoaded(jsonObject as List<ForecastEntity>)
            }

            override fun onError(jsonObject: String?) {
                view.onHideLoading()
                view.onError(jsonObject!!)
            }
        }
        model.loadForecast(latitude, longitude, responseListener)
    }
}