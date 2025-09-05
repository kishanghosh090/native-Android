package com.udemy.myrecipeapp

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState
    NavHost(
        navController = navController,
        startDestination = Screen.RecipeScreen.route,
        enterTransition = {
            scaleIn(
                animationSpec = tween (500),
                initialScale = 1.1f // Start a bit zoomed-in
            ) + fadeIn(animationSpec = tween(500))
        },
        exitTransition = {
            scaleOut(
                animationSpec = tween(500),
                targetScale = 0.9f // Shrinks before leaving
            ) + fadeOut(animationSpec = tween(500))
        },
        popEnterTransition = {
            scaleIn(
                animationSpec = tween(500),
                initialScale = 0.9f // Come back in with zoom
            ) + fadeIn(animationSpec = tween(500))
        },
        popExitTransition = {
            scaleOut(
                animationSpec = tween(500),
                targetScale = 1.1f // Zooms out slightly on back
            ) + fadeOut(animationSpec = tween(500))
        }
    ){
        composable (Screen.RecipeScreen.route){
            RecipeScreen(
                navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("category",it)
                navController.navigate(Screen.CategoryDetailScreen.route)
                }
                ,viewState = viewState)
        }
        composable(Screen.CategoryDetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category") ?: Category("","","","")
            CategoryDetailScreen(navController = navController, category = category)
        }

    }

}