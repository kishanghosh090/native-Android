package com.udemy.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navOptions


@Composable
fun SecondScreen(navController: NavController){
    val name = remember() {
        mutableStateOf("")
    }
    name.value = navController.currentBackStackEntry?.arguments?.getString("name") ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This is the  ${name.value}",
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp,

        )
        Button(
            onClick = {
                navController.navigate(
                    route = "FirstScreen",
                    navOptions = navOptions {
                        popUpTo("FirstScreen"){
                            inclusive = true
                        }
                    }
                    )
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "First Screen")
        }
    }
}