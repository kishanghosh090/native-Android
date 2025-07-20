package com.vedabits.wishlistapp.data

import android.content.Context
import androidx.room.Room

// it is a singleton which (object) is created only once
object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        Wishrepository(
            wishDao = database.wishDao()
        )
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}