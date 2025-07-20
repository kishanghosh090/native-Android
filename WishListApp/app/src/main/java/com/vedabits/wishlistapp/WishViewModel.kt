package com.vedabits.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")

    fun onWishTitleChanged(newTitle: String){
        title = newTitle
    }
    fun onWishDescriptionChanged(newDescription: String){
        description = newDescription
    }

}