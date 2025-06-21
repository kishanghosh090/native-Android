package com.example.jetpackcomposecourse.`4_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
@Preview( showBackground = true, showSystemUi = true)
fun ModifiersExamples(){
    Box(
        modifier = Modifier.fillMaxSize().background(
            color = Color.Cyan
        )
    ){}
}