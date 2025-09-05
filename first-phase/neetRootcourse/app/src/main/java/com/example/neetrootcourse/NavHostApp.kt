package com.example.neetrootcourse
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavHost(){

    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = routes.Login){
        composable <routes.Login>{
            LoginUi(navController)
        }
        composable <routes.Details>{
            val data = it.toRoute<routes.Details>()
            DetailsScreen(navController,data.name,data.password)
        }

    }
}