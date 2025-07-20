package com.vedabits.wishlistapp

import android.app.Application
import com.vedabits.wishlistapp.data.Graph

class WishListApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}