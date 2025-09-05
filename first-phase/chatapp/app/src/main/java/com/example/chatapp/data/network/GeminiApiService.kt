package com.example.chatapp.data.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface GeminiApiService {
    @Headers("Authorization: Bearer YOUR_API_KEY")
    @POST("v1beta/models/gemini-pro:generateContent")
    suspend fun generateContent(@Body request: GeminiRequest): GeminiResponse

    companion object {
        fun create(): GeminiApiService = Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GeminiApiService::class.java)
    }
}

