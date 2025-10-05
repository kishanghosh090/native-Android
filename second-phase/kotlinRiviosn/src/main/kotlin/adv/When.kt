package org.example.adv

fun main(){
    try {
        val input = readln().toIntOrNull() ///inc exe if readln not NULL
        input.let {
            println(input!! % 2 == 0)
        }
        if (input == null){
            return
        }

        var output = if(input % 2 == 0){
            val name = "the number is even"
            name
        }else{
            "the number is odd"
        }

        println(output)

        output = when(input) {
            in 10..20 -> "hee heee number fall in 10 to 20"
//        input % 2 == 0 -> "number is even ohoooooooo"
//        input % 2 != 0 -> "number is odd noooooooooooo"
            else -> {""}
        }

        println(input / 0)
        throw Exception("chai exception")
    }catch (e: Exception){
        println("exception happen $e")
    }




}