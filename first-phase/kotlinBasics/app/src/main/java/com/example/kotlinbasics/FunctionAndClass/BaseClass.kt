package com.example.kotlinbasics.FunctionAndClass

import kotlinx.coroutines.Dispatchers

open class BaseClass {


    open fun role(){
        println("member of the role of base class")
    }
    fun coreValues(){
        println("Core values are${Thread.currentThread()}")

    }
}