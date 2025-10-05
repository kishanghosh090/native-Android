package org.example.basic

fun main(){
    println("hello form chai code")

    var name = "kishan"
    val PI: Float = 3.12f
    // val is changeable var is not
    println("my name is ${name+name} and PI is equal to $PI")
    val isActive: Boolean = true


//    val input = readln().toIntOrNull() ?: 0
    val input = readln().toIntOrNull()?.inc() ///inc exe if readln not NULL
    input.let {
        println(input!! % 2 == 0)
    }

}