package com.davis.weatherapp.ui.view

import com.davis.weatherapp.core.BaseContract
import com.davis.weatherapp.core.ResponseListener
import com.davis.weatherapp.model.dbmodels.CurrentWeatherEntity
import com.davis.weatherapp.model.dbmodels.ForecastEntity

interface WeatherContract {
    interface view : BaseContract.view {
        fun onWeatherLoaded(currentWeatherEntity: CurrentWeatherEntity)
        fun onForecastLoaded(forecastEntity: List<ForecastEntity>)
    }

    interface presenter : BaseContract.presenter {
        fun requestWeather(latitude: String, longitude: String)
        fun requestForecast(latitude: String, longitude: String)
    }

    interface model {
        fun loadWeather(latitude: String, longitude: String, responseListener: ResponseListener)
        fun loadForecast(latitude: String, longitude: String, responseListener: ResponseListener)
    }
}