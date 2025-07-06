package com.udemy.authapp.presentation.login



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.authapp.data.datastore.UserPreferences
import com.udemy.authapp.data.repository.AuthRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository,
    private val prefs: UserPreferences
) : ViewModel() {

    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(email, password)
                prefs.saveToken(response.token) // ✅ Save token
                _token.value = response.token
            } catch (e: Exception) {
                _token.value = "ERROR: ${e.localizedMessage}"
            }
        }
    }
}
