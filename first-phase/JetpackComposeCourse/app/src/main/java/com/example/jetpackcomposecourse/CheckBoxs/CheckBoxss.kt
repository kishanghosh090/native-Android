package com.example.jetpackcomposecourse.CheckBoxs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState

@Composable
fun CheckBoxs(){
    var childCheckedStates = remember {
        mutableListOf(
            false,false,false
        )
    }

    val parentState = when{
        childCheckedStates.all{it} -> ToggleableState.On
        childCheckedStates.none() -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Select all")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckedStates.forEachIndexed { index, _ ->
                        childCheckedStates[index] = newState

                    }
                }
            )
        }

        childCheckedStates.forEachIndexed { index, isChecked ->
            Row(
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "option ${index+1}")
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        childCheckedStates[index] = it
                    },
                )
            }
        }
    }
    if (childCheckedStates.all { it }){
        Text(text = "All options selected")
    }

}