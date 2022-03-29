package com.davis.weatherapp.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.TypeConverter
import com.davis.weatherapp.util.DataConverter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.json.JSONObject

@Serializable
data class Forecast(
    @SerialName("message")
    var message: String = "", // 3600
    @SerialName("cnt")
    var cnt: Int = 0, // 10000
    @SerialName("list")
    var weather: List<CurrentWeather>,
    @SerialName("city")
    var city: City = City()
)
//    constructor(currentWeather :CurrentWeather):this(
//        weather = weather,
//    ){
//
//    }

   // companion object {
//        @JvmStatic
//        fun buildFromJson(jsonObject: JSONObject?): Forecast? {
//
////            jsonObject?.run {
////                return Forecast(
////                    optString("base"),
////                    Clouds.buildFromJson(optJSONObject("clouds"))!!,
////                    optInt("cod"),
////                    Coord.buildFromJson(optJSONObject("coord"))!!,
////                    optInt("dt"),
////                    optInt("id"),
////                    Main.buildFromJson(optJSONObject("main"))!!,
////                    optString("name"),
////                    Sys.buildFromJson(optJSONObject("sys"))!!,
////                    optInt("timezone"),
////                    optInt("visibility"),
////                    ArrayList<Weather>().apply {
////                        optJSONArray("weather")?.let {
////                            for(i in 0 until it.length()) {
////                                this.add(Weather.buildFromJson(it.getJSONObject(i))!!)
////                            }
////                        }
////                    },
////                    Wind.buildFromJson(optJSONObject("wind"))!!
////                )
////            }
////            return null
////        }
//    }
//}