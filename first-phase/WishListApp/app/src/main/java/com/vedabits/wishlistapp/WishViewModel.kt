package com.vedabits.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedabits.wishlistapp.data.Graph
import com.vedabits.wishlistapp.data.Wish
import com.vedabits.wishlistapp.data.Wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WishViewModel(
    private val wishRepository: Wishrepository = Graph.wishRepository
): ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")

    fun onWishTitleChanged(newTitle: String){
        title = newTitle
    }
    fun onWishDescriptionChanged(newDescription: String){
        description = newDescription
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getAllWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }
    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWish(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(id)
            // refresh the list
            getAllWishes = wishRepository.getAllWishes()

        }

    }

    fun getWishById(id: Long): Flow<Wish>{
        return wishRepository.getWishById(id)
    }

}