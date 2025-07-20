package com.vedabits.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = true
)
abstract  class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}