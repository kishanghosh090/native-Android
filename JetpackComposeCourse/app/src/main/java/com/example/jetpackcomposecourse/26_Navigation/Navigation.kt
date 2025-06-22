package com.example.jetpackcomposecourse.`26_Navigation`

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController


@Composable
fun App(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Main
    ){
        navigation<Navigation.Main>(startDestination = Routes.Home){
            composable <Routes.Home>{
                HomeScreen(navController = navController)
            }
            composable<Routes.Settings> {
                SettingsScreen(navController = navController)
            }
        }
    }
}