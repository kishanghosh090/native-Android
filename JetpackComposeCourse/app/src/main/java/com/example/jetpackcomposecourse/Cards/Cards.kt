package com.example.jetpackcomposecourse.Cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedCards(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        ElevatedCard (
            modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.2f),
            elevation = CardDefaults.cardElevation(
                10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = androidx.compose.ui.graphics.Color.Green
            )
        ){
            Text(
                text= "This is an elevated Card",
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center
                )
        }
    }
}