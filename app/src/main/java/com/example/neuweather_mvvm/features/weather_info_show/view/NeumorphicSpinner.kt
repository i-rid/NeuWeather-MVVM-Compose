package com.example.neuweather_mvvm.features.weather_info_show.view

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.neuweather_mvvm.features.weather_info_show.model.WeatherInfoShowModel
import com.example.neuweather_mvvm.features.weather_info_show.viewmodel.WeatherInfoViewModel
import com.example.neuweather_mvvm.theme.*

private enum class TemperatureContainerStatus {
    COLLAPSED,
    EXPANDED
}

@Composable
fun RadioButton(
    model: WeatherInfoShowModel,
    viewModel: WeatherInfoViewModel,
    updateImg: (String) -> Unit
) {
    val preview = true
    val textColor = MaterialTheme.colors.getMainViewTopBarViewTextColor()
    var isCityPicked by remember {
        mutableStateOf(false)
    }
    var citySelected by remember {
        mutableStateOf("")
    }

    var temperatureContainerStatus by remember {
        mutableStateOf(
            if (preview) TemperatureContainerStatus.EXPANDED else TemperatureContainerStatus.COLLAPSED
        )
    }
    val temperatureContainerTransition =
        updateTransition(targetState = temperatureContainerStatus)
    val temperatureContainerWidth by temperatureContainerTransition.animateDp {
        when (it) {
            TemperatureContainerStatus.COLLAPSED -> 130.dp
            TemperatureContainerStatus.EXPANDED -> 200.dp
        }
    }
    val temperatureContainerHeight by temperatureContainerTransition.animateDp {
        when (it) {
            TemperatureContainerStatus.COLLAPSED -> 110.dp
            TemperatureContainerStatus.EXPANDED -> 400.dp
        }
    }

    NeumorphismCardSquareView(
        modifier = Modifier
            .width(temperatureContainerWidth)
            .height(temperatureContainerHeight),
        backgroundColor = MaterialTheme.colors.getMainViewTopViewCardColor(),
        onClick = {
//            userAction.onTemperatureClick()
            temperatureContainerStatus = when (temperatureContainerStatus) {
                TemperatureContainerStatus.COLLAPSED -> TemperatureContainerStatus.EXPANDED
                TemperatureContainerStatus.EXPANDED -> TemperatureContainerStatus.COLLAPSED
            }
        }
    ) {
        Box(
            modifier = Modifier
                .width(130.dp)
                .height(100.dp)
                .align(Alignment.TopEnd)
                .zIndex(2f)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .zIndex(2f)
                    .wrapContentWidth()
                    .wrapContentHeight(),
                text = if(!isCityPicked) "Cities" else citySelected,
                fontSize = if(citySelected == "Chittagong" || citySelected == "Mymensingh" )16.sp else 20.sp,
                fontWeight = FontWeight(900),
                color = textColor
            )
//            if ("" == "") {
//                CircularProgressIndicator(
//                    modifier = Modifier
//                        .width(24.dp)
//                        .height(24.dp)
//                        .align(Alignment.Center)
//                        .zIndex(2f),
//                    color = textColor
//                )
//            }
        }
        val temperatureUnityAlpha by temperatureContainerTransition.animateFloat {
            when (it) {
                TemperatureContainerStatus.COLLAPSED -> 0f
                TemperatureContainerStatus.EXPANDED -> 1f
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 32.dp)
                .alpha(temperatureUnityAlpha)
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = "City List",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = textColor
            )
//            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Dhaka"
                        viewModel.getWeatherInfo(1185241,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Dhaka",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor

                )
            }
//            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.METRIC)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Barishal"
                        viewModel.getWeatherInfo(1336137,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.METRIC)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Barishal",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }
//            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.IMPERIAL)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Chittagong"
                        viewModel.getWeatherInfo(1337200,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.IMPERIAL)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Chittagong",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Khulna"
                        viewModel.getWeatherInfo(1336135,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Khulna",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Mymensingh"
                        //update it
                        viewModel.getWeatherInfo(1185162,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Mymensingh",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Rajshahi"
                        viewModel.getWeatherInfo(1185128,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Rajshahi",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Rangpur"
                        viewModel.getWeatherInfo(1185188,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Rangpur",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
//                    userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                }
                    .height(35.dp)
            ) {
                androidx.compose.material.RadioButton(
                    selected = false,
                    onClick = {
                        isCityPicked = true
                        citySelected = "Sylhet"
                        viewModel.getWeatherInfo(1185099,model)
                        updateImg(
                            citySelected
                        )
//                        userAction.onTemperatureUnitClicked(WeatherUnit.STANDARD)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sylhet",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = textColor
                )
            }

        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun RadioButtonPreview() {
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
//                RadioButton()
            }
        }
    }
}

