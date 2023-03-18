package com.example.neuweather_mvvm.features.weather_info_show.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.neuweather_mvvm.features.weather_info_show.model.WeatherInfoShowModel
import com.example.neuweather_mvvm.features.weather_info_show.model.WeatherInfoShowModelImpl
import com.example.neuweather_mvvm.theme.MainTheme
import com.example.neuweather_mvvm.theme.getMainViewBottomBackgroundColor
import com.example.neuweather_mvvm.theme.getMainViewTopBackgroundColor
import com.example.neuweather_mvvm.features.weather_info_show.view.MainView
import com.example.neuweather_mvvm.features.weather_info_show.viewmodel.WeatherInfoViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    private lateinit var model: WeatherInfoShowModel
    private lateinit var viewModel: WeatherInfoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MainTheme {
                Surface {
                    Box(
                        modifier = Modifier.background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colors.getMainViewTopBackgroundColor(),
                                    MaterialTheme.colors.getMainViewBottomBackgroundColor()
                                )
                            )
                        )
                    ) {

                        SystemBarColorLight(Color(0XFFEEF0F5))  //light
//                        SystemBarColorDark() //dark
                        model = WeatherInfoShowModelImpl(applicationContext)
                        viewModel = ViewModelProvider(this@MainActivity).get(WeatherInfoViewModel::class.java)
                        viewModel.getCityList(model)
                        MainView(model,viewModel,this@MainActivity,applicationContext)
                    }
                }
            }

        }
    }
}
@Preview
@Composable
fun MainActivityPreview(){
}

@Composable
fun SystemBarColorLight(color: Color){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(
            color = color,
            darkIcons = true
        )
    }
}

@Composable
fun SystemBarColorDark(){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFF394253),
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(
            color = Color(0xFF181C27),
            darkIcons = true
        )
    }
}