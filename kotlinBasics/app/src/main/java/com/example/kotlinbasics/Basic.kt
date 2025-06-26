package com.example.kotlinbasics

fun main(){
    print("hello kotlin with chai \n")
    var name: String? = null
    name?.let {
        println("Length: ${it.length}")
    }
    println("Length: ${name?.length}")
}