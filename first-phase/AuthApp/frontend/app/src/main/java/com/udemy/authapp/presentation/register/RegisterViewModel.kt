package com.udemy.authapp.presentation.register



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.authapp.data.datastore.UserPreferences
import com.udemy.authapp.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: AuthRepository,
    private val prefs: UserPreferences
) : ViewModel() {

    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.register(name, email, password)
                prefs.saveToken(response.token)
                _token.value = response.token
            } catch (e: Exception) {
                _token.value = "ERROR: ${e.localizedMessage}"
            }
        }
    }
}
