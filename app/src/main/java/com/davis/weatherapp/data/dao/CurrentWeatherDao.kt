package com.davis.weatherapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.davis.weatherapp.model.CurrentWeather
import com.davis.weatherapp.model.dbmodels.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {

    @Query("SELECT * FROM CurrentWeather")
    fun getCurrentWeather(): List<CurrentWeatherEntity>

    @Query("SELECT * FROM CurrentWeather ORDER BY abs(lat-:lat) AND abs(lon-:lon) LIMIT 1")
    fun getCurrentWeather(lat: Double, lon: Double): CurrentWeatherEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Transaction
    fun deleteAndInsert(currentWeatherEntity: CurrentWeatherEntity) {
        deleteCurrentWeather()
        insertCurrentWeather(currentWeatherEntity)
    }

    @Query("DELETE FROM CurrentWeather")
    fun deleteCurrentWeather()

    @Query("Select count(*) from CurrentWeather")
    fun getCount(): Int
}
