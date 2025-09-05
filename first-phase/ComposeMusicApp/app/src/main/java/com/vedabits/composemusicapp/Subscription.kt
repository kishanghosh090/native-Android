package com.vedabits.composemusicapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Subscription() {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Subscription")
        Card (
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            onClick = { /*TODO*/ },
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ){
            Column (
                modifier = Modifier.padding(16.dp)
            ){
                Text(text = "Subscription")
                Text(text = "Subscription")
                Text(text = "Subscription")
                Text(text = "Subscription")
            }

        }

    }
}