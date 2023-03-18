package com.example.neuweather_mvvm.network

import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    fun callApiForWeatherInfo(@Query("id") cityId: Int) : Call<WeatherInfoResponse>
}