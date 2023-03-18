package com.example.neuweather_mvvm.features.weather_info_show.view

import android.animation.AnimatorInflater
import android.graphics.Color
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherButtonLabel
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherDataModel
import com.example.neuweather_mvvm.theme.*
import soup.neumorphism.NeumorphImageButton
import soup.neumorphism.R
import soup.neumorphism.ShapeType

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun ForecastCellView(
    weather: WeatherButtonLabel,
    modifier: Modifier = Modifier,
    preview: Boolean = false
) {
//    val userAction = Mvp(preview = preview, weather = weather).createUserAction()
    Column(
        modifier = modifier
            .height(150.dp)
    ) {
        Box(
            modifier = modifier
                .height(130.dp)
        ) {
            val light = MaterialTheme.colors.isLight
            val topStartShadowColor = if (light) "#C6CEDA" else "#101010"
            val bottomEndShadowColor = if (light) "#FEFEFF" else "#262C37"
            val forecastViewCardColor = MaterialTheme.colors.getForecastViewCardColor()
            AndroidView(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                factory = { context ->
                    NeumorphImageButton(context).apply {
                        setShadowColorLight(Color.parseColor(bottomEndShadowColor))
                        setShadowColorDark(Color.parseColor(topStartShadowColor))
                        setShapeType(ShapeType.DEFAULT)
                        setBackgroundColor(
                            argb(
                                forecastViewCardColor.alpha,
                                forecastViewCardColor.red,
                                forecastViewCardColor.green,
                                forecastViewCardColor.blue
                            )
                        )
                        if (!preview) {
                            stateListAnimator = AnimatorInflater.loadStateListAnimator(
                                context,
                                R.animator.button_state_list_anim_neumorph
                            )
                        }
                        setOnClickListener {
                        }
                    }
                }
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(14.dp)
            ) {
                if (weather == null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .align(Alignment.Center)
                                .zIndex(2f),
                            color = MaterialTheme.colors.getTextPrimaryColor()
                        )
                    }
                } else {
//                    WeatherIconView(
//                        weatherType = weather.type,
//                        modifier = Modifier.weight(2.2f)
//                    )
//                    LottieExample()
//                    val image =
//                        AnimatedImageVector.animatedVectorResource(R.drawable.abc_ic_clear_material)
//                    val atEnd by remember { mutableStateOf(false) }
//                    Icon(
//                        painter = rememberAnimatedVectorPainter(image, atEnd),
//                        contentDescription = null // decorative element
//                    )
                    Image(
                        painter = painterResource(weather.imageId),
                        contentDescription = "desc",
                        modifier = modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        Text(
//                            text = "${weather.btnInfo.toInt()}°",
                            text = weather.btnInfo.toString(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(900),
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(bottom = 4.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (weather != null) {
                // To put in presenter the text creation
                Text(
                    text = weather.btnLabel,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(900),
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(bottom = 4.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

private fun argb(alpha: Float, red: Float, green: Float, blue: Float): Int {
    return (alpha * 255.0f + 0.5f).toInt() shl 24 or
            ((red * 255.0f + 0.5f).toInt() shl 16) or
            ((green * 255.0f + 0.5f).toInt() shl 8) or
            (blue * 255.0f + 0.5f).toInt()
}






@Composable
fun NeuMorphicCell(weather: WeatherDataModel) {

    //    val userAction = Mvpp(preview).createUserAction()
//    val weathersState = userAction.getWeathers().observeAsState()
//    val weathers = WeatherDataModel()

    val preview = false
    MainTheme(true) {
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
                Row {
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weather,weather.temperature+"°","Tmp"),
                        modifier = Modifier.weight(1f),
                        preview = preview
                    )
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weathertwo,weather.sunrise,"Sunrise"),
                        modifier = Modifier.weight(1f),
                        preview = preview
                    )
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weatherthree,weather.sunset,"Sunset"),
                        modifier = Modifier.weight(1f),
                        preview = preview
                    )
                    ForecastCellView(
                        weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weatherfour,weather.visibility,"Visibility"),
                        modifier = Modifier.weight(1f),
                        preview = preview
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

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun ForecastCellViewLightPreview() {
    MainTheme {
        Surface {
            MainViewBackgroundView {
                ForecastCellView(
                    modifier = Modifier.align(Alignment.BottomStart),
                    weather = WeatherButtonLabel(com.example.neuweather_mvvm.R.drawable.weather,"32","Temperature"),
                    preview = true
                )
            }
        }
    }
}
@Preview
@Composable
fun NeuMorphicCellPreview() {
    NeuMorphicCell(weatherFake)
}

public val weatherFake =  WeatherDataModel("","","","","","","","","","")

