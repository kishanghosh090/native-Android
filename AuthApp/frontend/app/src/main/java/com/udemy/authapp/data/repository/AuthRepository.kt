package com.udemy.authapp.data.repository


import com.udemy.authapp.data.api.AuthApi
import com.udemy.authapp.data.api.AuthResponse
import com.udemy.authapp.data.dto.AuthRequest
import com.udemy.authapp.data.dto.RegisterRequest


class AuthRepository(private val api: AuthApi) {
    suspend fun register(name: String, email: String, password: String): AuthResponse {
        return api.register(RegisterRequest(name, email, password))
    }

    suspend fun login(email: String, password: String): AuthResponse {
        return api.login(AuthRequest(email, password))
    }
}