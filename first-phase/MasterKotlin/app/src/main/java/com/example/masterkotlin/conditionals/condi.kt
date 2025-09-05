package com.example.masterkotlin.conditionals

// conditional statements

// if and else
fun main(){
    var isTea: Boolean = true
    isTea = false
    if(isTea){
        println("hello from chai")
    }else{
        println("hello from akash")
    }

    var myNumber: Int = 1
    when(myNumber){
        1 -> println("hello from 1")
        2 -> println("hello from 2")
        3 -> println("hello from 3")
        else -> println("hello from else")

    }
}