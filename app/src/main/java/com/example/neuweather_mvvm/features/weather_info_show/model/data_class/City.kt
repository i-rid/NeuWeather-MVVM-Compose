package com.example.neuweather_mvvm.features.weather_info_show.model.data_class
import com.google.gson.annotations.SerializedName

data class City (
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("country")
    val country: String = ""
): java.io.Serializable