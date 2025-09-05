package com.vedabits.wishlistapp

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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
        composable(route = Screen.AddScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = -1L
                    nullable = false
                }
            )
        ){
            val id = it.arguments?.getLong("id") ?: -1L
            if (id == -1L){
                viewModel.title = ""
                viewModel.description = ""
            }else{
                val wish = viewModel.getWishById(id).collectAsState(initial = null).value
                viewModel.title = wish?.title ?: ""
                viewModel.description = wish?.description ?: ""
            }

            AddEditDetailView(
                id = id,
                viewModel = viewModel,
                navController = navController
            )

        }

    }
}