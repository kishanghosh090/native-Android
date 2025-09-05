package com.example.newjetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newjetpackcomposecourse.`1_introduction`.Greeting
import com.example.newjetpackcomposecourse.`2_FundamentalConcepts`.AccessString
import com.example.newjetpackcomposecourse.ui.theme.NewJetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewJetpackComposeCourseTheme {
                AccessString()
            }
        }
    }
}

//@Preview
//@Composable
//fun GreetingPreview() {
//    NewJetpackComposeCourseTheme {
//        AccessString()
//    }
//}