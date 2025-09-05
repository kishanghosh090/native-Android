package com.example.kotlinbasics.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//
//fun main(){
//    var a = 10
//    var b = 23
//
//    Thread {
//        // background work
//        println("Running in thread 1st: ${Thread.currentThread().name}")
//    }.start()
//    Thread {
//        // background work
//        println("Running in thread 2nd: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 3rd: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 4th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 5th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 6th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 7th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 8th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 9th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 10th: ${Thread.currentThread().name}")
//    }.start()
//
//    Thread {
//        // background work
//        println("Running in thread 11th: ${Thread.currentThread().name}")
//    }.start()
//    Thread {
//        // background work
//        println("Running in thread 12th: ${Thread.currentThread().name}")
//    }.start()
//    Thread {
//        // background work
//        println("Running in thread 13th: ${Thread.currentThread().name}")
//    }.start()
//
//    println("$a + $b = ${a+b}")
//    println("Running in thread: ${Thread.currentThread().name}")
//
//}
// ---------------------------------------------------------------------------------------------------
//fun main(): kotlin.Unit = runBlocking {
//    println("Main thread: ${Thread.currentThread().name}")
//
//    launch (Dispatchers.Default) {
//        delay(1000)
//        println("Default thread: ${Thread.currentThread().name}")
//    }
//    println("After launch")
//
//    launch(Dispatchers.IO) {
//        println("IO thread: ${Thread.currentThread().name}")
//    }
//
//    launch(Dispatchers.Unconfined) {
//        delay(1000)
//        println("Unconfined thread: ${Thread.currentThread().name}")
//    }
//    println("After launch")
//}
// --------------------------------------------------------------------------

import kotlinx.coroutines.*
import kotlin.system.*

suspend fun fetchQuote(): String {
    println("🔄 [${Thread.currentThread().name}] Fetching quote...")
    delay(2000) // simulate API delay
    return "🌟 Be yourself; everyone else is taken."
}

fun main() = runBlocking {
    println("🚀 App started on: ${Thread.currentThread().name}")

    // Simulate ViewModelScope
    val job = CoroutineScope(Dispatchers.IO).launch {
        try {
            val quote = fetchQuote()

            withContext(Dispatchers.Main.immediate) { // simulate Main thread
                println("✅ [${Thread.currentThread().name}] Showing quote: $quote")
            }

        } catch (e: CancellationException) {
            println("❌ [${Thread.currentThread().name}] Job was cancelled!!!")
        }
    }
    CoroutineScope(Dispatchers.IO).launch {
        delay(1000)
        job.cancel()
    }

    // Simulate user leaving screen after 1s
    delay(1000)
    println("🛑 User left screen. Cancelling coroutine...")
    job.cancel() // simulate onCleared()

    job.join() // wait for coroutine to end
    println("🧹 App closed.")
}
