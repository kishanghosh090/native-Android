package com.example.composemusicapp

//import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed  class Screen(
    val title: String,
    val route: String
) {

    sealed class DrawerScreen(
        val dTitle: String,
        val dRoute: String,
//        @DrawableRes val icon: Int // ( may it )
        val icon: ImageVector
    ): Screen(dTitle,dRoute){
        object Account: DrawerScreen(
            dTitle = "Account",
            dRoute = "account",
            Icons.Default.AccountCircle
        )
        object Subscription: DrawerScreen(
            dTitle = "Subscription",
            dRoute = "Subscribe",
            Icons.Default.Favorite
        )
        object AddAccount: DrawerScreen(
            dTitle = "Add Account",
            dRoute = "addAccount",
            Icons.Default.AddCircle
        )
    }

}