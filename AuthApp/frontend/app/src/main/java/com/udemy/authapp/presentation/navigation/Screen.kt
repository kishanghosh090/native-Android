package com.udemy.authapp.presentation.navigation

sealed class Screen(val route: String) {
    object Register : Screen("register")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object Splash : Screen("splash")

}