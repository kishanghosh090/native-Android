package com.udemy.myrecipeapp

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
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = true,
                    error = null
                )
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    list = response.categories,
                    error = null
                )
            }catch (e:Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }finally {

            }
        }
    }

  data class RecipeState(
      val isLoading: Boolean = false,
      val list: List<Category> = emptyList(),
      val error: String? = null,
      )
}