package com.example.masterkotlin.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {
    println("code start ${Thread.currentThread().name}")

    CoroutineScope(Dispatchers.IO).launch {
        val result = fetchData()
        println("code in coroutine $result ${Thread.currentThread().name}")
    }

    println("code end ${Thread.currentThread().name}")

    Thread.sleep(3000)
}

// 1. Dispatchers.IO is optimized for network and disk I/O operations.
// used for fetching data from network and performing disk operations.(API calling)
// 2. Dispatchers.Default is optimized for CPU-intensive operations. heavy computation
// 3. Dispatchers.Main is used to update the UI in the main thread. Used to update the UI in the main thread.
// 4. Dispatchers.Unconfined is used to run a coroutine in the caller thread.(Starts in the current thread but may switch to another thread)
