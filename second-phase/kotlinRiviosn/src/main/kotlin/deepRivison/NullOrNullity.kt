package org.example.deepRivison

fun main(){
    val input = readln()

    val inputInt = input.toIntOrNull()  // null --> 1,3,5,6..

    println(inputInt)
    inputInt?.let {

    }



    val myVal = readln().toIntOrNull() ?: 0


    val final= when{
        myVal % 2 == 0-> {
            "even"
        }
        myVal %2 != 0 -> {
            "odd"
        }
        else -> {
            "no nothing"
        }
    }
    val myVal2 = readln().toIntOrNull()
    val finalS = when(myVal2){
        null -> {
            "null number"
        }
        2-> {
            "even"
        }
        3 -> {
            "odd"
        }
        else -> {
            "no nothing"
        }
    }

    println(finalS)
}