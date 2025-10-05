package com.example.masterkotlin.coroutines.coroutineRivison2

import kotlin.concurrent.thread

fun main(){
    getUserInfoCallBack("1"){user->
        println(user)
    }
//    println(getUser("1"))
    println("hello from kishan and chai")
}

fun getUser(userId: String): User{
    Thread.sleep(3000)
    return User(userId, "Kishan")
}

// could not block the thread
fun getUserInfoCallBack(userId: String, onComplete: (User) -> Unit){
    thread {
        Thread.sleep(3000)
        onComplete(User(userId, "Kishan"))
    }
}