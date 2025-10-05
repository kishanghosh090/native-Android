package org.example.adv

fun main(){
    val numbs = mutableListOf<String>()
    numbs.add("elychi")
    numbs.add("ginger")
    numbs.add("oolong")
    numbs.add("earl gray")

    numbs.forEach { it -> println(it) }


    val input = readln()

    val finalString = buildString {
        for(i in input.lastIndex downTo 0){
            append(input[i])
        }
    }
    println(finalString)
    println("hello")
}