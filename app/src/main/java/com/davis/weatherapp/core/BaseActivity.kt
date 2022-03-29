package com.davis.weatherapp.core

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.davis.weatherapp.data.RoomDb
import com.davis.weatherapp.util.DataConverter

open class BaseActivity : AppCompatActivity() {
    var roomDatabase:RoomDb.WeatherDatabase ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // getAppDatabase()
        setTransparentStatusBar()
    }
    fun getAppDatabase(): RoomDb.WeatherDatabase? {
        if (roomDatabase==null){
            roomDatabase = Room.databaseBuilder(
                baseContext,
                RoomDb.WeatherDatabase::class.java, "WeatherDb"
            ) .allowMainThreadQueries()
                .build()
        }
        return roomDatabase
    }

    private fun setTransparentStatusBar() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }
}