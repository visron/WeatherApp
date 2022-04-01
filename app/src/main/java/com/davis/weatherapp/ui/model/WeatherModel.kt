package com.davis.weatherapp.ui.model

import android.util.Log
import com.davis.weatherapp.core.ResponseListener
import com.davis.weatherapp.data.RoomDb
import com.davis.weatherapp.repository.ForecastRepository
import com.davis.weatherapp.repository.WeatherRepository
import com.davis.weatherapp.ui.view.WeatherContract
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherModel : WeatherContract.model {
    var localDb = RoomDb.WeatherDatabase.appDatabase
    override fun loadWeather(
        latitude: String,
        longitude: String,
        responseListener: ResponseListener
    ) {
        var currentWeatherDao = localDb!!.currentWeatherDao()
//        CoroutineScope(Dispatchers.IO).launch {
        GlobalScope.launch {
            var data = WeatherRepository().makeWeatherRequest(
                latitude,
                longitude,
                "metric",
                currentWeatherDao
            )
            Log.v("WeatherModel", "data :: $data")
            if (data.toString().trim().toLowerCase().equals("no internet connection")) {
                responseListener.onError("Please Check Your Internet Connection")
            } else
                if (data is Exception) {
                    responseListener.onError(data.message.toString())
                } else {
                    responseListener.onSuccess(data)
                }
        }
    }

    override fun loadForecast(
        latitude: String,
        longitude: String,
        responseListener: ResponseListener
    ) {
        var forecastDao = localDb!!.ForecastDao()
//        CoroutineScope(Dispatchers.IO).launch {
        GlobalScope.launch {
            var data = ForecastRepository().makeForecastRequest(
                latitude,
                longitude,
                "metric",
                forecastDao
            )
            Log.v("WeatherModel", "data :: $data")
            if (data.toString().trim().toLowerCase().equals("no internet connection")) {
                responseListener.onError("Please Check Your Internet Connection")
            } else
                if (data is Exception) {
                    responseListener.onError(data.message.toString())
                } else {
                    responseListener.onSuccess(data)
                }
        }
    }
}
