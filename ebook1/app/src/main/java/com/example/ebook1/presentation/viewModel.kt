package com.example.ebook1.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ebook1.common.BookCategoryModel
import com.example.ebook1.common.BookModel
import com.example.ebook1.common.ResultState
import com.example.ebook1.domain.repo.AllBookRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class viewModel @Inject constructor(val repo: AllBookRepo): ViewModel() {
    private val _state: MutableState<ItemState> = mutableStateOf(ItemState())
    val state: MutableState<ItemState> = _state

    fun BringAllBooks() {
        viewModelScope.launch {
            repo.getAllBooks().collect {
                when (it) {
                    is ResultState.Success -> {
                        _state.value = ItemState(items = it.data)
                    }
                    is ResultState.Error -> {
                        _state.value = ItemState(error = it.exception.message.toString())
                    }

                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }

                }
            }
        }
    }

    fun BringAllCategory() {
        viewModelScope.launch {
            repo.getAllCategory().collect {
                when (it) {
                    is ResultState.Success -> {
                        _state.value = ItemState(category = it.data)
                    }

                    is ResultState.Error -> {
                        _state.value = ItemState(error = it.exception.message.toString())
                    }

                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }
                }
            }
        }

    }

    fun bringAllBooksByCategory(category: String) {
        viewModelScope.launch {
            repo.getAllBooksByCategory(category).collect {
                when (it) {
                    is ResultState.Success -> {
                        _state.value = ItemState(items = it.data)
                    }
                    is ResultState.Error -> {
                        _state.value = ItemState(error = it.exception.message.toString())
                    }
                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }
                }
            }
        }
    }
}
data class ItemState(
    val isLoading: Boolean = false,
    val items: List<BookModel> = emptyList(),
    val error: String = "",
    val category: List<BookCategoryModel> = emptyList(),
)