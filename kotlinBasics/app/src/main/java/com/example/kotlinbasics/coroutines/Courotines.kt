package com.example.kotlinbasics.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun fetchQuote1(): String {
    delay(2000)
    return "Be yourself."
}

suspend fun fetchQuote2(): String {
    delay(3000)
    return "Stay hungry, stay foolish."
}

fun main() = runBlocking {
    val q1 = async { fetchQuote1() }
    val q2 = async { fetchQuote2() }

    println("Quotes:")
    println("1: ${q1.await()}")
    println("2: ${q2.await()}")

    println("End of program")
}
