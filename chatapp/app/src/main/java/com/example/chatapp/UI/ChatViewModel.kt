package com.example.chatapp.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.models.Message
import com.example.chatapp.data.network.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val api = GeminiApiService.create()

    fun sendMessage(userText: String) {
        _messages.value = _messages.value + Message("User", userText)

        viewModelScope.launch {
            try {
                val request = GeminiRequest(
                    contents = listOf(
                        GeminiContent(parts = listOf(GeminiPart(text = userText)))
                    )
                )
                val response = api.generateContent(request)
                val reply = response.candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text ?: "No response"
                _messages.value = _messages.value + Message("Bot", reply)
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Unknown error occurred"
                _messages.value = _messages.value + Message("Bot", "Something went wrong.")
            }
        }
    }

    fun clearError() {
        _error.value = null
    }
}
