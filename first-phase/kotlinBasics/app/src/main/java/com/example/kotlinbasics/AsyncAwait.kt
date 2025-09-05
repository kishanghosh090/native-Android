package com.example.kotlinbasics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun getUserData(): String {
    delay(2000)
    return "User Data"
}

suspend fun getPosts(): String {
    delay(1500)
    return "Posts"
}

suspend fun fetchInParallel() = coroutineScope {
    val userDeferred = async { getUserData() }
    val postsDeferred = async { getPosts() }

    val user = userDeferred.await()
    val posts = postsDeferred.await()

    println("Fetched: $user and $posts")
}

fun main() = runBlocking {
    val job = CoroutineScope(Dispatchers.IO).launch {
        fetchInParallel()
    }
    job.join()
    println("App closed")
}
