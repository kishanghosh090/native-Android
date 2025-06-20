package com.example.jetpackcomposecourse.`3_CoreComponents`


import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
//@Preview(showBackground = true, showSystemUi = true)
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

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun colorFulText(){
    val rainboColor = listOf(
        Color.Red,
//        Color.Yellow,
        Color.Green,
        Color.Blue,
        Color.Magenta
    )
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
      Text(
          text = buildAnnotatedString {
              append("jetpack compose \n")
              withStyle (
                  SpanStyle(
                      brush = Brush.linearGradient(
                          colors = rainboColor
                      )
                  )
              ){
                  append("is awesome")
              }
          }
      )

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScrollableText(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Hello jetpack compose . I am Kishan rana ghosh. i start jetpack compose with chai".repeat(50),
            color = Color.Blue,
            modifier = Modifier.basicMarquee(),
            fontSize = 30.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
    }
}

