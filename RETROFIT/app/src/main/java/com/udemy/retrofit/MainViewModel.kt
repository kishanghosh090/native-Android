package com.udemy.retrofit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private  fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    categories = response.categories
                )

            }catch (e: Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }

        }
    }
    

    data class RecipeState(
        val isLoading: Boolean = true,
        val categories: List<Category> = emptyList(),
        val error: String? = null
    )
}