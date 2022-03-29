package com.davis.weatherapp.core

interface BaseContract {
    interface view {
        fun onShowLoading()
        fun onJideLoading()
    }

    interface presenter {
        fun onDestroy()
    }

    interface model
}