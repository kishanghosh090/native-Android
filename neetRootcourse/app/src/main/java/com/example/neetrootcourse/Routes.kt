package com.example.neetrootcourse

import kotlinx.serialization.Serializable

sealed class routes{
    @Serializable
    object Login

    @Serializable
    data class Details(
        val name: String,
        val password: String
    )

}