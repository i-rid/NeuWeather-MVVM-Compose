package com.example.neuweather_mvvm.experiment_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import kotlin.math.max
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.neuweather_mvvm.R

@Composable
fun LottieA() {
    // to keep track if the animation is playing
    // and play pause accordingly
    var isPlaying by remember {
        mutableStateOf(true)
    }

// for speed
    var speed by remember {
        mutableStateOf(1f)
    }

// remember lottie composition, which
// accepts the lottie composition result
    val composition by rememberLottieComposition(

        LottieCompositionSpec
            // here `code` is the file name of lottie file
            // use it accordingly
            .RawRes(R.raw.weatherpartlycloudy)
    )

    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which it was paused
        restartOnPlay = false
    )

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Heading
        Text(
            text = "Lottie",
            color = Color.Gray,
            fontSize = 70.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(10.dp)
        )

        // LottieAnimation
        // Pass the composition and the progress state
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(400.dp)
        )

        // Buttons to control the animation
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Button to decrease speed
                Button(
                    onClick = {
                        // check to prevent speed going negative
                        speed = max(speed - 0.25f, 0f)
                    },
                    // Button background color
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF0F9D58)
                    )
                ) {
                    Text(
                        text = "-",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,

                        )
                }

                // Button to Increase speed
                Text(
                    text = "Speed ( $speed ) ",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp, modifier = Modifier.padding(horizontal = 10.dp)

                )
                Button(
                    onClick = {
                        // Increase the speed by 0.25
                        speed += 0.25f
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF0F9D58)
                    )
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            // Button to pause and play
            Button(
                onClick = {
                    // change isPlaying state to pause/play
                    isPlaying = !isPlaying
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF0F9D58)
                )
            ) {
                Text(
                    // display text according to state
                    text = if (isPlaying) "Pause" else "Play",
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PrevLottie(){
//    LottieExample()
}

@Composable
fun LottieExample() {

    // to keep track if the animation is playing
    // and play pause accordingly
    var isPlaying by remember {
        mutableStateOf(true)
    }
    // for speed
    var speed by remember {
        mutableStateOf(1f)
    }

    // remember lottie composition ,which
    // accepts the lottie composition result
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.bouncingload)
    )


    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart when paused and play
        // pass false to continue the animation at which it was paused
        restartOnPlay = false

    )
    LottieAnimation(
        composition,
        progress,
        modifier = Modifier
            .clickable {
                isPlaying = !isPlaying
            }
    )

    // Column Composable
//    Column(
//        Modifier
//            .background(Color.Transparent)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Heading
////        Text(
////            text = "Lottie",
////            color = Color.Gray,
////            fontSize = 70.sp,
////            fontWeight = FontWeight.SemiBold,
////            modifier = Modifier.padding(10.dp)
////        )
//
//        // LottieAnimation
//        // Pass the composition and the progress state
//
//
//        // Buttons to control the animation
//        Row(
//            horizontalArrangement = Arrangement.SpaceAround,
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
////            Row(
////                horizontalArrangement = Arrangement.SpaceBetween,
////                verticalAlignment = Alignment.CenterVertically
////            ) {
////
////                // Button to decrease speed
////                Button(
////                    onClick = {
////                        // check to prevent speed going negative
////                        speed = max(speed - 0.25f, 0f)
////                    },
////                    // Button background color
////                    colors = ButtonDefaults.buttonColors(
////                        backgroundColor = Color(0xFF0F9D58)
////                    )
////                ) {
////                    Text(
////                        text = "-",
////                        color = Color.White,
////                        fontWeight = FontWeight.Bold,
////                        fontSize = 20.sp,
////
////                        )
////                }
////
////                 //Button to Increase speed
////                Text(
////                    text = "Speed ( $speed ) ",
////                    color = Color.Black,
////                    fontWeight = FontWeight.Bold,
////                    fontSize = 15.sp, modifier = Modifier.padding(horizontal = 10.dp)
////
////                )
////                Button(
////                    onClick = {
////                        // Increase the speed by 0.25
////                        speed += 0.25f
////                    },
////                    colors = ButtonDefaults.buttonColors(
////                        backgroundColor = Color(0xFF0F9D58)
////                    )
////                ) {
////                    Text(
////                        text = "+",
////                        color = Color.White,
////                        fontWeight = FontWeight.Bold,
////                        fontSize = 20.sp
////                    )
////                }
////            }
//
//            // Button to pause and play
////            Button(
////                onClick = {
////                    // change isPlaying state to pause/play
////                    isPlaying = !isPlaying
////                },
////                colors = ButtonDefaults.buttonColors(
////                    backgroundColor = Color(0xFF0F9D58)
////                )
////            ) {
////                Text(
////                    // display text according to state
////                    text = if (isPlaying) "Pause" else "Play",
////                    color = Color.White
////                )
////            }
//        }
//    }
}