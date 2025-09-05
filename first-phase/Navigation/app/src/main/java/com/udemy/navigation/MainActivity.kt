package com.udemy.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.udemy.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "FirstScreen",

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
    ) {
        composable("FirstScreen"){
            FirstScreen(navController)
        }
        composable("SecondScreen/{name}"){
            SecondScreen(navController)
        }

    }


}