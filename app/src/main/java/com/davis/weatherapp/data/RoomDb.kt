package com.davis.weatherapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.davis.weatherapp.data.dao.CurrentWeatherDao
import com.davis.weatherapp.data.dao.ForecastDao
import com.davis.weatherapp.model.CurrentWeather
import com.davis.weatherapp.model.dbmodels.CurrentWeatherEntity
import com.davis.weatherapp.model.dbmodels.ForecastEntity
import com.davis.weatherapp.util.DataConverter

class RoomDb {
    @Database(
        entities = [
            CurrentWeatherEntity::class,
            ForecastEntity::class,
        ],
        version = 1
    )
    @TypeConverters(DataConverter::class)
    abstract class WeatherDatabase : RoomDatabase() {
        abstract fun currentWeatherDao(): CurrentWeatherDao
        abstract fun ForecastDao(): ForecastDao
    }

}