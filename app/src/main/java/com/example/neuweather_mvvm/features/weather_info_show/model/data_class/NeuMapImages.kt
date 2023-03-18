package com.example.neuweather_mvvm.features.weather_info_show.model.data_class

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.neuweather_mvvm.R

public val maps: Map<String, Int> = mapOf(
    "Barishal" to R.drawable.neu_barishal,
    "Chittagong" to R.drawable.neu_ctg,
    "Dhaka" to R.drawable.neu_dhaka,
    "Khulna" to R.drawable.neu_khulna,
    "Mymensingh" to R.drawable.neu_mymensingh,
    "Rajshahi" to R.drawable.neu_rajshahi,
    "Rangpur" to R.drawable.neu_rangpur,
    "Sylhet" to R.drawable.neu_sylhet
)

@Composable
fun getMapImg(name: String): Painter {
    return painterResource(maps[name]!!)
}