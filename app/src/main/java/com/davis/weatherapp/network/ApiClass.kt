package com.davis.weatherapp.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TIME_OUT = 60_000

class ApiClass {
    private val ktorHttpClient = HttpClient(Android) {

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    // Log.v("Logger Ktor =>", message)
                }

            }
            level = LogLevel.BODY
        }

        install(ResponseObserver) {
            onResponse { response ->
                //Log.d("HTTP status:", "${response.status.value}")
            }
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            parameter("appid", "b9af021a08c28c84cf82b45514e13ad6")
        }


    }

    fun getClient(): HttpClient {
        return ktorHttpClient;
    }
}