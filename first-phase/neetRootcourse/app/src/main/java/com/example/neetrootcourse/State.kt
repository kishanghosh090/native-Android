package com.example.neetrootcourse

import android.util.MutableInt
import androidx.collection.mutableIntSetOf
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun State(){

    var count = remember { mutableStateOf(0)  }
//    var value by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "count = ${count.value}", fontSize = 24.sp)

        Button(onClick = {
            count.value++
        }) {
            Text(text = "Increment")
        }
        Button(onClick = {
            count.value--
        }) {
            Text(text = "Decrement")
        }

    }
}