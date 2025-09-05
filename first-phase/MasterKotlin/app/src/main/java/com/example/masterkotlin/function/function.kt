package com.example.masterkotlin.function

fun main(){
    println("hello world")
    greet("kishan")
    run()
    add(1,2)
    printValue("kishan")
    greet("kishan")
    greetMe("kishan")
//    println(greetYou ("kishan"){ name -> "Hello $name ...are you fine?"  })
    println(greetYou ("kishan"){  "Hello $it ...are you fine?"  })

    var person = Person("kishan")
    person.introduced()

    val d = Dog()
    d.sound() // → Dog barks
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
// higher order function
fun greetYou(name: String, action: (String) -> String): String {
    return action(name)
}


fun action(name: String): String {
    return "hello $name"
}

// member function

class Person(val name: String) {
    var itIS = this.name
    fun introduced(){
        println("this is it ${itIS}")

        println("i am $name")
    }
}

// overriding function

open class Animal {
    open fun sound() {
        println("Animal makes a sound")
    }
}

class Dog : Animal() {
    override fun sound() {
        println("Dog barks")
    }
}


