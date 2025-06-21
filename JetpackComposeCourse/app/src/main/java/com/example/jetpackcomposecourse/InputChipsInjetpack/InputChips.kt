package com.example.jetpackcomposecourse.InputChipsInjetpack

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun InputChipSample() {
    var enabled by remember { mutableStateOf(false) }
    if (!enabled){
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InputChip(
                onClick = {
                    enabled = !enabled
                },
                label = { Text("Disabled Input Chip") },
                selected = enabled,
                enabled = true,
                avatar = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = "Lock")
                }


            )
        }
    }

}