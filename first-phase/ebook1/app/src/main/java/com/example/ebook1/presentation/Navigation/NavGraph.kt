package com.example.ebook1.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.ebook1.presentation.AllBooksByCategory.BookByCategoryScreen
import com.example.ebook1.presentation.HomeScreen.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen>{
            HomeScreen(navHostController = navHostController)
        }
        composable < Routes.ShowPdfScreen>{navBackStackEntry ->
            val data : Routes.ShowPdfScreen = navBackStackEntry.toRoute()
        }
        composable < Routes.BooksByCategory>{navBackStackEntry ->
            val data : Routes.BooksByCategory = navBackStackEntry.toRoute()
            BookByCategoryScreen(data.category, navHostController = navHostController)
        }
    }
}