package com.davis.weatherapp.network


import com.davis.weatherapp.model.CurrentWeather
import com.davis.weatherapp.model.Forecast
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class WeatherApi(private val client: HttpClient) {
    suspend fun getCurrentWeather(
        lat: String, lon: String, units: String
    ): CurrentWeather = client.get("https://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$lon&units=$units")
    suspend fun getForecast(
        lat: String, lon: String, units: String
    ): Forecast =
        client.get("https://api.openweathermap.org/data/2.5/forecast?lat=$lat&lon=$lon&units=$units")

//    suspend fun getForecast(
//
//    ) {
//        client.post<UserEntity>("$END_POINT_POST_USER_KTOR") {
//            body = user
//        }
//    }
}