package com.vedabits.composemusicapp

import androidx.annotation.DrawableRes

sealed class Screens(val title: String, val route: String) {
    sealed class DrawerScreens(
        val dTitle: String,
        val dRoute: String,
        @DrawableRes val icon: Int):
        Screens(dTitle, dRoute)
    {
            object Account: DrawerScreens(
                "Account",
                "Account",
                R.drawable.outline_account_circle_24
            )
            object Subscription: DrawerScreens(
                "Subscription",
                "Subscribe",
                R.drawable.outline_subscriptions_24
            )
            object AddAccount: DrawerScreens(
                "Add Account",
                "AddAccount",
                R.drawable.outline_person_24
            )
        }
}