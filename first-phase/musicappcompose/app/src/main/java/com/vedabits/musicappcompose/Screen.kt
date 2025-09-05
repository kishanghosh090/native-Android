package com.vedabits.musicappcompose

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {
    sealed class DrawerScreen(
        val dTitle: String,
        val dRoute: String,
        @DrawableRes val dIcon: Int) : Screen(dTitle, dRoute){
//            object Account : DrawerScreen("Account", "account", R.drawable.ic_account)
//            object Subscription : DrawerScreen("Subscription", "subscription", R.drawable.ic_subscription)


        }

}