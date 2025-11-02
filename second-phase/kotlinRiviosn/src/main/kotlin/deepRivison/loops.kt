package org.example.deepRivison

fun main(){

    for(i in 0..10){ // last number inclusive
        println(i)
    }

    println("Enter a number to print it in console...")

    val size = readln().toIntOrNull() ?: 0

    for(i in 0 until  size){// exclusive the last range
        println("$i")
    }

    for(i in mutableListOf<Int>(34,56,67,78,89) ){
        println(i)
    }


    val finalString = buildString {
        for (i in "kishan rana ghosh".lastIndex downTo 0){
            append("$i ${when{i>0 -> "+" else -> ""}} ")
        }
    }
    println(finalString)
}