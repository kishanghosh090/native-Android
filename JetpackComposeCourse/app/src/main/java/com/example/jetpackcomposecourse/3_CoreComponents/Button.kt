package com.example.jetpackcomposecourse.`3_CoreComponents`

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R


@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun ButtonInJetPackCompose(){
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.background(Color.Green),

        ) {
            Text(
                text = "Click Me",
                fontWeight = FontWeight.W900,
                color = Color.White,
                
            )
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun FilledButtonSample(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
       Column {
           FilledTonalButton(
               onClick = {
                   Toast.makeText(context, "$LocalContext", Toast.LENGTH_SHORT).show()
               }
           ) {
               Text(text = "Filled Button")
           }

           OutlinedButton(
               onClick = {
                   Toast.makeText(context, "$context", Toast.LENGTH_SHORT).show()
               }
           ) {
               Text(text = "Outlined Button")
           }

           ElevatedButton(
               onClick = {
                   Toast.makeText(context, "$context", Toast.LENGTH_SHORT).show()
               }
           ) {
               Text(text = "JetPack compose")
           }
           TextButton(
               onClick = {
                   Toast.makeText(context, "$context", Toast.LENGTH_SHORT).show()
               },
               shape = CircleShape,
               modifier = Modifier.background(Color.Green).clip(RoundedCornerShape(16.dp))

           ) {
               Text(text = "Text Button")
           }
       }
    }
}