package com.example.masterkotlin.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val launchJob = launch {
        println("launch job start")
        delay(1000L)
        println("launch job end")

    }
    val asyncJob = async {
        println("async job start")
        delay(1000L)
        println("async job end")
        "Async code end"
    }

    launchJob.join()
//    println("hello ${launchJob}")
    println(asyncJob.await())

}