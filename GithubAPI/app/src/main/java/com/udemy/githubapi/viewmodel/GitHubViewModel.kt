package com.udemy.githubapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.githubapi.data.GitHubUser
import com.udemy.githubapi.data.recipeService
import kotlinx.coroutines.launch


class GitHubViewModel : ViewModel() {

    var user by mutableStateOf<GitHubUser?>(null)
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)



    fun fetchUser(username: String) {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                user = recipeService.getUser(username)
            } catch (e: Exception) {
                error = "User not found"
            } finally {
                isLoading = false
            }
        }
    }
}


