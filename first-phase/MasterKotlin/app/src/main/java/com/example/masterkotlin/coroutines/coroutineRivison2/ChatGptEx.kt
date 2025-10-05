package com.example.masterkotlin.coroutines.coroutineRivison2

import kotlinx.coroutines.*
import kotlin.random.Random

// Mimic API request function
suspend fun fetchApiData(apiName: String): String {
    delay(Random.nextLong(500, 1500)) // simulate network delay
    if (Random.nextInt(10) < 2) throw Exception("$apiName failed!") // mimic occasional API failure
    return "$apiName response"
}

fun main() = runBlocking { // CoroutineScope tied to main thread
    println("🚀 Starting Coroutine Demo")

    // 1️⃣ CoroutineScope and lifecycle
    val scope = CoroutineScope(Dispatchers.Default)

    // 2️⃣ launch vs async
    val job1 = scope.launch { // launch: fire & forget, returns Job
        try {
            val data1 = fetchApiData("API-1")
            println("✅ Launch received: $data1")
        } catch (e: Exception) {
            println("❌ Error in launch: ${e.message}")
        }
    }

    val deferred: Deferred<String> = scope.async { // async: returns Deferred<T>
        fetchApiData("API-2")
    }

    // 3️⃣ Structured concurrency with coroutineScope
    scope.launch {
        try {
            coroutineScope { // ensures child coroutines complete before finishing
                val data2 = deferred.await() // await result from async
                println("✅ Async received: $data2")
            }
        } catch (e: Exception) {
            println("❌ Error in structured concurrency: ${e.message}")
        }
    }

    // 4️⃣ Job and cancellation
    delay(1000)
    if (!job1.isCompleted) {
        println("⏹ Cancelling job1...")
        job1.cancel(CancellationException("Manual cancellation"))
    }

    // 5️⃣ Exception handling
    val handler = CoroutineExceptionHandler { _, exception ->
        println("⚠️ Caught exception: ${exception.localizedMessage}")
    }

    scope.launch(handler) {
        val result = fetchApiData("API-3")
        println("✅ API-3 result: $result")
    }

    // 6️⃣ Coroutine builders and dispatchers
    scope.launch(Dispatchers.IO) { // IO dispatcher for network
        val ioResult = fetchApiData("API-4")
        println("🌐 IO Dispatcher result: $ioResult")
    }

    // 7️⃣ Cancellation and timeout
    try {
        withTimeout(2000L) { // cancel if not completed in 2 seconds
            val timeoutResult = fetchApiData("API-5")
            println("⏱ Timeout result: $timeoutResult")
        }
    } catch (e: TimeoutCancellationException) {
        println("⏳ API-5 timed out!")
    }

    // Wait for all coroutines to finish
    delay(3000)
    println("🏁 All coroutines demo finished")
}
