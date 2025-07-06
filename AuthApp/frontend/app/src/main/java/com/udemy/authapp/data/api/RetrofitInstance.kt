package com.udemy.authapp.data.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/api/auth/") // TODO: Update this
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
}
