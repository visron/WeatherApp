package com.davis.weatherapp.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.json.JSONObject



@Serializable
data class Coord(
    @SerialName("lat")
    var lat: Int = 0, // 57
    @SerialName("lon")
    var lon: Int = 0 // 10
) {
    companion object {
        @JvmStatic
        fun buildFromJson(jsonObject: JSONObject?): Coord? {

            jsonObject?.run {
                return Coord(
                    optInt("lat"),
                    optInt("lon")
                )
            }
            return null
        }
    }
}