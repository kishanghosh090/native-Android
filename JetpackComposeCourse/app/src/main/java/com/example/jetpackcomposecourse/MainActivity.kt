package com.example.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecourse.`3_CoreComponents`.AnotatedStringWithListner
import com.example.jetpackcomposecourse.`3_CoreComponents`.ButtonInJetPackCompose
import com.example.jetpackcomposecourse.`3_CoreComponents`.FilledButtonSample
import com.example.jetpackcomposecourse.`3_CoreComponents`.LoginScreen
import com.example.jetpackcomposecourse.`3_CoreComponents`.OutTextField
import com.example.jetpackcomposecourse.`4_LayoutComposables`.CardList
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MaterialTheme(
                        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
                    ){
//                        OutTextField()
//                        LoginScreen()
//                        AnotatedStringWithListner()
//                        ButtonInJetPackCompose()
//                        FilledButtonSample()
                        CardList(innerPadding)
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box (
            modifier = Modifier
                .clip(RoundedCornerShape(23.dp))
                .background(Color(0xAAcFB1F1))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable{
//                    println("Hello Android")
                }
                .shadow(elevation = 8.dp)


        ){
            Text(
                text = "Hello Android",
                color = Color.Black
            )
        }
        FancyButton(text = "Click Me", onClick = {

        })
    }
}

@Composable
fun FancyButton(text: String, onClick: () -> Unit) {
    Button (
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3F51B5), // Custom color
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCourseTheme {
        Greeting("Android")
//        FancyButton(text = "Click Me", onClick = {})
    }
}