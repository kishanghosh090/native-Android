package com.example.masterkotlin.NullSafety

fun main(){
//    var name: String? = null

    // ? safe call operator
    // null ..
//    println(name?.length)



    // ?: elvis operator

    var name: String? = "kishan"
    val length = name?.length ?: -1
//    println(length)

    // !! not null assertion operator
    println(name!!.length)

    // as? safe cast operator
    var obj: Any = "String"
    var str: String? = obj as? String
    println(str)

    // use of let with safe call operator
    //in kotlin 'let' is a scope function that executes a block of code within the context of an object and returns the object itself.

    name?.let {
        println("name is $it") // executed only if name is not null
    }



}