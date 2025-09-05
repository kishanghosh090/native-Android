package com.example.ebook1.presentation.Navigation

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object HomeScreen

    @Serializable
    data class BooksByCategory(val category: String, val navHostController: NavHostController)

    @Serializable
    data class ShowPdfScreen(val url: String)



}