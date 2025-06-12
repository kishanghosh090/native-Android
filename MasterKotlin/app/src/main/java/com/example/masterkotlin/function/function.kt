package com.example.masterkotlin.function

fun main(){
    println("hello world")
    greet("kishan")
    run()
    add(1,2)
}

// user defined function
fun greet(name: String): String {
    return "welcome $name"
}

// unit returning function(a function that does not return any value it is similar to void in java)
// fun run(): Unit {
// println("i am running")
//}

fun run() : Unit {
    println("i am running")
}

// single expression function
fun add(a: Int, b: Int): Int = a + b


// explicit return type
// fun add(a: Int, b: Int): Int {
// return a + b
// }





