package com.vedabits.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao: WishDao) {

    suspend  fun addWish(wish: Wish) {
        wishDao.addWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id: Long): Flow<Wish> = wishDao.getWishById(id)

    suspend fun updateWish(wish: Wish) {
        wishDao.updateWish(wish)
    }
    suspend fun deleteWish(id: Long) {
        wishDao.deleteWish(id)
    }


}