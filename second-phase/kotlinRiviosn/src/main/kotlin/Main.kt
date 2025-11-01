package org.example

fun main() {
//    var name = "kishan"
//    println("hello from $name")
//
//    name = readonly()
//
//
//    if(name.length >5){
//        println("hello can you need tea")
//    }else{
//        println("hello do you need coffee")
//    }
//
//
//    println("hello from kishan")

    val i = 0;


        outer@ while (true){
            val j = 0
            outer@ for (k in j..10){
                if (k == 0) break@outer
            }
            break@outer

        }

    println(i)
    return
}