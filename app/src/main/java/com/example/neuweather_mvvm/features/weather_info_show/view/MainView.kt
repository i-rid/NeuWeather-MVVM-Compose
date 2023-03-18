package com.example.neuweather_mvvm.features.weather_info_show.view

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.ViewModelProvider
import com.example.neuweather_mvvm.R
import com.example.neuweather_mvvm.features.weather_info_show.model.WeatherInfoShowModel
import com.example.neuweather_mvvm.features.weather_info_show.model.WeatherInfoShowModelImpl
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.*
import com.example.neuweather_mvvm.features.weather_info_show.viewmodel.WeatherInfoViewModel
import com.example.neuweather_mvvm.theme.MainTheme

@Composable
fun MainView(
    model: WeatherInfoShowModel,
    viewModel: WeatherInfoViewModel,
    mainActivity: MainActivity,
    applicationContext: Context
) {
    var mapName by rememberSaveable{ mutableStateOf("Dhaka")}
    var time by rememberSaveable{ mutableStateOf("12:34")}
    var date by rememberSaveable{ mutableStateOf("29 Feb, 1234")}

    val cityList : MutableList<City> = mutableListOf()
    var cc by remember { mutableStateOf(cityList) }
    var weather by remember { mutableStateOf(WeatherDataModel()) }
    var error by remember { mutableStateOf(false) }

    viewModel.cityListLiveData.observe(mainActivity){

    }
    viewModel.cityListFailureLiveData.observe(mainActivity){

    }
    viewModel.weatherInfoLiveData.observe(mainActivity){
        weather = it
        val list = weather.dateTime.split(" - ")
        date = list[0]
        time = list[1]
        Log.d("NETWORKCALL", "$time:$date")
    }
    viewModel.weatherInfoFailureLiveData.observe(mainActivity){

    }







    Surface(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        val image = painterResource(R.drawable.map_sample)
        MainViewBackgroundView {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .zIndex(2f)
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    Column(Modifier.padding(start = 15.dp)) {
                        Text(
//                            "09:48 PM"
                            time,
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight(900),
                            modifier = Modifier
                                .wrapContentHeight())
                        Text(
//                            "07 March, 2023"
                            date,
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight(900),
                            modifier = Modifier
                                .wrapContentHeight())
                        Text(
                            if(weather.cityAndCountry == "") "${mapName}, BD" else weather.cityAndCountry,
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight(900),
                            modifier = Modifier
                                .wrapContentHeight())
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    RadioButton(model,viewModel){
                        mapName = it
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Center)
                    .zIndex(1f)
            ){
                Image(
                    painter = painterResource(maps [mapName]!!) ,
//                        if (mapName == "Dhaka") painterResource(R.drawable.map_sample) else painterResource(id = R.drawable.neu_dhaka)
                    contentDescription = null,
                    Modifier
                        .size(750.dp),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 6.dp, end = 6.dp)
                    .align(Alignment.BottomCenter)
                    .zIndex(4f)
            ) {
//                NeuMorphicCell(weather)
                Row {
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weather,weather.temperature+"°","Tmp"),
                        modifier = Modifier.weight(1f),
                        preview = true
                    )
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weathertwo,weather.sunrise,"Sunrise"),
                        modifier = Modifier.weight(1f),
                        preview = true
                    )
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weatherthree,weather.sunset,"Sunset"),
                        modifier = Modifier.weight(1f),
                        preview = true
                    )
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weatherfour,weather.visibility,"Visibility"),
                        modifier = Modifier.weight(1f),
                        true
                    )
//                    ForecastCellView(
//                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weatherfour,weather.visibility,"Visibility"),
//                        modifier = Modifier.weight(1f),
//                        preview = preview
//                    )
//
                }
            }
        }
    }
}

@Preview
@Composable
fun MainViewPreview(){

}