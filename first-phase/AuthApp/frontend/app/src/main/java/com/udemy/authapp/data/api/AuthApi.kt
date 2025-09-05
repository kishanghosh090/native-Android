package com.udemy.authapp.data.api


import com.udemy.authapp.data.dto.AuthRequest
import com.udemy.authapp.data.dto.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("register")
    suspend fun register(@Body body: RegisterRequest): com.udemy.authapp.data.api.AuthResponse

    @POST("login")
    suspend fun login(@Body body: AuthRequest): com.udemy.authapp.data.api.AuthResponse
}
