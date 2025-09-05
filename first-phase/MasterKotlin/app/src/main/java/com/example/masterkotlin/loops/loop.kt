package com.example.masterkotlin.loops

fun main(){
    for (j in 1..5){
        for (i in 1..5){
            print("*")
        }
        println()

    }

    var fruits: Array<String> = arrayOf("apple","banana","orange")
    for (fruit in fruits){
        println(fruit)
    }
}