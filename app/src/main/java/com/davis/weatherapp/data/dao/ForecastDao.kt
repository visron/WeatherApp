package com.davis.weatherapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.davis.weatherapp.model.CurrentWeather
import com.davis.weatherapp.model.dbmodels.CurrentWeatherEntity
import com.davis.weatherapp.model.dbmodels.ForecastEntity

@Dao
interface ForecastDao {

    @Query("SELECT * FROM Forecast")
    fun getCurrentWeather(): List<ForecastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeatherEntity: ForecastEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(currentWeatherEntity: List<ForecastEntity>)

    @Transaction
    fun deleteAndInsert(currentWeatherEntity: ForecastEntity) {
        deleteCurrentWeather()
        insertCurrentWeather(currentWeatherEntity)
    }

    @Query("DELETE FROM Forecast")
    fun deleteCurrentWeather()

    @Query("Select count(*) from Forecast")
    fun getCount(): Int
}
