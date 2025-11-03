package org.example.deepRivison

fun main(){
    val input = readln()

    val letterOnly = input.map { value ->
//        println(value)
        value.isLetter()
    }
//    println(input)
//    println(letterOnly)

    val lamda: (Char) -> Boolean = {
        it.isLetter()
    }
    val onlyLetter = input.filter(lamda)

    val myFilter = input.myFilter { it ->
        it.isLetter() || it == ' '
    }
    println(myFilter)


}


fun String.myFilter(predicate: (Char) -> Boolean): String {
    return buildString {
        for(i in this@myFilter){
            if (predicate(i)){
                append(i)
            }
        }
    }
}