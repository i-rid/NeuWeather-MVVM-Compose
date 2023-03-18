package com.example.neuweather_mvvm.features.weather_info_show.model

import com.example.neuweather_mvvm.common.RequestCompleteListener
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.City
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherInfoResponse

interface WeatherInfoShowModel {
    fun getCityList(callback: RequestCompleteListener<MutableList<City>>)
    fun getWeatherInformation(cityId: Int, callback: RequestCompleteListener<WeatherInfoResponse>)
}