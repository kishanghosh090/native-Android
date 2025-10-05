package org.example.adv



fun main(){
    val input = readln()

    val lambda: (Char) -> Boolean = {
        it.isLetter()
    }

//    val lettersOnly = input.filter {it -> it.isLetter() }
    var lettersOnly = input.filter (lambda)
    println(lettersOnly)
    println(lambda('c'))

    lettersOnly = input.myFilter(lambda)

    println(lettersOnly)
}

fun String.myFilter(predicate: (Char) -> Boolean) : String{

    return buildString {
        for (char in this@myFilter){
            if(predicate(char)){
                this.append(char)
            }
        }
    }
}