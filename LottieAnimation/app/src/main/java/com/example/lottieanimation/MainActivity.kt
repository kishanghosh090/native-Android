package com.example.lottieanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.size

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimation.ui.theme.LottieAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LottieAnimationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Lottie()
//                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Lottie(){
    val state by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.welcome)
    )
    val progress by animateLottieCompositionAsState(
        state,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LottieAnimation(
            composition = state,
            progress = { progress },

            modifier = Modifier.align(Alignment.Center).size(200.dp)
        )
    }
}
