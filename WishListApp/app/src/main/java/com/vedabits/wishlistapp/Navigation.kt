package com.vedabits.wishlistapp

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
    ) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        enterTransition = {
            slideInVertically()
        },
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { -it }
            )
        }

    ){
        composable(route = Screen.HomeScreen.route){
            HomeView(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(route = Screen.AddScreen.route){
            AddEditDetailView(
                id = -1,
                viewModel = viewModel,
                navController = navController
            )

        }

    }
}