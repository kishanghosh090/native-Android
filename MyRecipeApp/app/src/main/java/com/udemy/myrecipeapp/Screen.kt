package com.udemy.myrecipeapp

sealed class Screen(val route: String) {
    object RecipeScreen : Screen("recipeScreen")
    object CategoryDetailScreen : Screen("categoryDetailScreen")
}