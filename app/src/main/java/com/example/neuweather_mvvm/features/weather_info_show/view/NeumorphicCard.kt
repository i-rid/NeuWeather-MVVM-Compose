package com.example.neuweather_mvvm.features.weather_info_show.view

import android.animation.AnimatorInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.neuweather_mvvm.theme.MainTheme
import com.example.neuweather_mvvm.theme.getMainViewBottomBackgroundColor
import com.example.neuweather_mvvm.theme.getMainViewTopBackgroundColor
import soup.neumorphism.NeumorphImageButton
import soup.neumorphism.R
import soup.neumorphism.ShapeType

@Composable
fun NeumorphismCardSquareView(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    @ShapeType shapeType: Int = ShapeType.FLAT,
    backgroundColor: Color = Color.Transparent,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
    ) {
        val light = MaterialTheme.colors.isLight
        val topStartShadowColor = if (light) "#C6CEDA" else "#101010"
        val bottomEndShadowColor = if (light) "#FEFEFF" else "#262C37"
        AndroidView(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            factory = { context ->
                NeumorphImageButton(context).apply {
                    setShadowColorLight(android.graphics.Color.parseColor(bottomEndShadowColor))
                    setShadowColorDark(android.graphics.Color.parseColor(topStartShadowColor))
                    setShapeType(shapeType)
                    setBackgroundColor(
                        argb(
                            backgroundColor.alpha,
                            backgroundColor.red,
                            backgroundColor.green,
                            backgroundColor.blue
                        )
                    )
                    stateListAnimator = AnimatorInflater.loadStateListAnimator(
                        context,
                        R.animator.button_state_list_anim_neumorph
                    )
                    if (onClick != null) {
                        setOnClickListener {
                            onClick()
                        }
                    }
                }
            }
        )
        content()
    }
}

private fun argb(alpha: Float, red: Float, green: Float, blue: Float): Int {
    return (alpha * 255.0f + 0.5f).toInt() shl 24 or
            ((red * 255.0f + 0.5f).toInt() shl 16) or
            ((green * 255.0f + 0.5f).toInt() shl 8) or
            (blue * 255.0f + 0.5f).toInt()
}

@Composable
fun MainViewBackgroundView(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colors.getMainViewTopBackgroundColor(),
                    MaterialTheme.colors.getMainViewBottomBackgroundColor()
                )
            )
        )
    ) {
        content()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun NeumorphismCardSquareViewLightPreview() {
    MainTheme {
        MainViewBackgroundView {
            NeumorphismCardSquareView(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(160.dp)
                    .height(160.dp)
            ) {
            }
        }
    }
}