package com.example.smile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smile.ui.theme.SmileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    smileFace()
                }
            }
        }
    }
}

@Composable
fun smileFace() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val faceRadius = 100.dp.toPx()
        val eyeRadius = 50f


        drawCircle(
            color = Color.Yellow,
            radius = faceRadius,
            center = Offset(centerX, centerY)
        )


        drawCircle(
            color = Color.Black,
            radius = eyeRadius,
            center = Offset(centerX + faceRadius / 2, centerY - faceRadius / 3)
        )


        drawCircle(
            color = Color.Black,
            radius = eyeRadius,
            center = Offset(centerX - faceRadius / 2, centerY - faceRadius / 3)
        )


        drawArc(
            color = Color.Black,
            startAngle = 20f,
            sweepAngle = 140f,
            useCenter = false,
            style = Stroke(width = 5.dp.toPx()),
            topLeft = Offset(centerX - faceRadius / 2, centerY),
            size = Size(faceRadius, faceRadius / 2)
        )
    }
}

