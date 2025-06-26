package com.example.kotlinbasics
//
//fun main(){
//    print("hello kotlin with chai \n")
//    var name: String? = null
//    name?.let {
//        println("Length: ${it.length}")
//    }
//    println("Length: ${name?.length}")
//    val address: String? = "Mangalbari malda"
//
//    address?.let {
//        println("Length: ${it.length}")
//    }
//
//    val age: Int? = readln().toIntOrNull()
//
//}
//
//fun main(){
////    val name: String? = "Kishan"
//
////    name?.let {
////        println("Name is $it")
////    }
//
////    val user = User().apply {
////         name = "Kishan"
////         age = 20
////        isActive = true
////    }
//
//    val list = mutableListOf(1, 2, 3).also {
//        println("Original list: $it")
//    }.map { it * 2 }
//
//
//    data class User(var name: String, var email: String)
//
//    val user = User("Kishan", "k@example.com")
//
//// let
//    val usernameUpper = user.name.let { it.uppercase() }
//
//// apply
//    val newUser = User("", "").apply {
//        name = "Rana"
//        email = "rana@example.com"
//    }
//
//// also
//    val updatedUser = user.also {
//        println("Updating user: $it")
//    }.apply {
//        name = "Kishan Ghosh"
//    }
//
//
//}


//fun main() {
////    val builder = StringBuilder().apply {
////        append("Kishan ")
////        append("is ")
////        append("Awesome!")
////    }.also {
////        println("String built: $it")
////    }
//data class Person(var name: String = "", var age: Int = 0)
//
//        val person = Person().apply {
//            name = "Alice"
//            age = 30
//        }
//
////        println(person) // Output: Person(name=Alice, age=30)
//
//
//    val name: String? = "Kishan"
//
//    val myName = name?.let { it->
//        val length = it.length
//        println("Length: ${it.length}")
//        length
//        it
//    }
//    println(myName)
//
//}
//

data class Person(var name: String = "", var age: Int = 0)

fun main() {
    // apply
    val person = Person().apply {
        name = "Alice"
        age = 30
    }
    println("apply: $person")

    // also
    val numbers = mutableListOf(1, 2, 3).also {
        println("also - Initial list: $it")
        it.add(4)
    }
    println("also: $numbers")

    // let
    val input: String? = "Hello Kotlin"
    val length = input?.let {
        println("let - Value: $it")
        it.length
    } ?: 0
    println("let - Length: $length")

    // run
    val result = "Android".run {
        val upper = this.uppercase()
        "run - Original: $this | Uppercase: $upper"
    }
    println(result)

    // with
    val str = "Kotlin"
    val output = with(str) {
        "with - Original: $this | Length: ${this.length}"
    }
    println(output)
}