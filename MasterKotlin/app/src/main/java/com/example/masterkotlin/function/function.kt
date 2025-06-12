package com.example.masterkotlin.function

fun main(){
    println("hello world")
    greet("kishan")
    run()
    add(1,2)
    printValue("kishan")
    greet("kishan")
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



// generic function in kotlin( a function that can work with different types of data)
fun <T> printValue(value: T) {
    println(value)
}

// lambda function and higher order function in kotlin ( a function that is not declared but passed as an argument to another function)

val greetMe: (String) -> Unit = { name ->
    when(name){
        "kishan" ->  println("hello kishan")
        "akash" -> println("hello akash")
        else -> println("hello guest")
    }

}
