package com.udemy.authapp.data.dto

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)