package com.example.jetpackcomposecourse.`3_CoreComponents`


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun simpleText(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Hello jetpack compose",
            color = Color.Blue,
            modifier = Modifier.align(Alignment.Center),
            maxLines = 1,
            softWrap = false,
            onTextLayout = {
                println(it.size)
            },
            fontWeight = FontWeight.W900,
            fontSize = 30.sp,

        )
    }
}

