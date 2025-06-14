package com.example.masterkotlin.coroutines
import kotlinx.coroutines.*

// 1. what i Coroutines in kotlin
// coroutines are light weight threads that allow you to write asynchronous code
// coroutines are used to perform tasks that take a long time to complete
// coroutines are used to perform tasks that are not blocking the main thread
// what is asynchronous code or non blocking code
// Thread: A thread is a sequence of instructions that can be executed by the CPU

//  program -> becomes a process when it is executed
// process -> becomes a thread when it is executed ( contain multiple threads )
// coroutines are used to perform tasks that are not blocking the main thread(lightweight and efficient)


//fun main() = runBlocking { // coroutines scope
//        launch { // launch a new coroutine and continue
//            delay(1000L) // non blocking delay for 1 second (default time unit is ms)
//            println("Hello from coroutine") // print after delay
//        }
//
//        println("Hello from main thread") // main thread continues while coroutine is delayed
//
//
//}



// suspending function

suspend fun network(){
    delay(1000L)
    println("data fetched from network")

}


fun main() = runBlocking{
//    Thread.sleep(1000L)
    launch {
        network()
    }

    println("main thread")
}