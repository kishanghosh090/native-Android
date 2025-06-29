package com.example.kotlinbasics.Lists

fun main(){
    val shoppingList = listOf("Processor","ram","graphics card","SSD") // immutable list
    val shoppingMulable = mutableListOf("Processor","ram","graphics card","SSD") // mutable list
    shoppingMulable.add("mother board")
    shoppingMulable.remove("ram")
    shoppingMulable.removeAt(0)

    println("is contain " + shoppingMulable.contains("SSD"))

    for (
        item in 0 until shoppingList.size
    ){
        println("$item " + shoppingList[item])
    }
    var i = 0
    while (i < shoppingMulable.size){
        println(shoppingMulable[i])
        i++
    }
    println("----------end---------------")
    shoppingList.forEach { value ->
        println(value)
    }



}