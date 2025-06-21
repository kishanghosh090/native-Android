package com.example.jetpackcomposecourse.scaffoldJetpack

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecourse.`4_LayoutComposables`.CardList
import com.example.jetpackcomposecourse.AlartDilogBox.CustomBeautifulDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScaffoldSample(){
    var presses by remember { mutableIntStateOf(0) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold Sample")
                },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.inverseSurface,
                ),
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                content = {
                    Text(text = "Bottom App Bar")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton (onClick = { presses++ }) {
                Text(text = "Floating Action Button")
            }
        },

    ){ innerpadding ->
        CustomBeautifulDialog()
        CardList(innerpadding)

    }
}