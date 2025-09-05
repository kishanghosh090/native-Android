package com.example.masterkotlin.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

suspend fun fetchData(): String{
    delay(2000L)
    return "User Data Fetched successfully"
}
//fun main(){
//    println("code start ${Thread.currentThread().name}")
//
//    GlobalScope.launch {
//        val data = fetchData()
//        println("$data on 1 ${Thread.currentThread().name}")
//    }
//    GlobalScope.launch {
//        val data = fetchData()
//        println("$data on 2${Thread.currentThread().name}")
//    }
//    println("code end ${Thread.currentThread().name}")
//
//
//
//    Thread.sleep(3000)
//}


// Four main scope in coroutines
// GlobalScope
// CoroutineScope

//val scope = CoroutineScope(Dispatchers.IO)
//scope.launch {
//    // do some work
//}
//scope.cancel() // cancel the scope

// LifeCycleScope(scope for android activity and fragment)

// ViewModelScope(scope for viewmodel)

class MyViewModel: ViewModel(){
    init {
        viewModelScope.launch {
            while (true){
                delay(1000L)
                println("Hello from viewmodel")
            }
        }
    }
}

// SupervisorScope

fun main() = runBlocking{
    supervisorScope {
        launch {
            delay(1000L)
            println("Hello from launch 1")
        }
        launch {
            delay(2000L)
            throw Exception("child2 Failed")
        }
        launch {
            delay(3000L)
            println("Hello from launch 3")
        }
    }
    println("Hello from runblocking")
}