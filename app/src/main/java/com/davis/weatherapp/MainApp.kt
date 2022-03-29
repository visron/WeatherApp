package com.davis.weatherapp

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import androidx.room.Room
import androidx.room.RoomDatabase
import com.davis.weatherapp.data.RoomDb
import com.davis.weatherapp.model.Main
import com.davis.weatherapp.util.DataConverter

class MainApp : Application() {
    var context:Context ?=null

    override fun onCreate() {
        super.onCreate()
        context = this@MainApp
        instance = this
    }

    companion object {
        @JvmField
        var context: Context? = null
        protected lateinit var instance: MainApp
    }

    init {
        instance = this
    }
}