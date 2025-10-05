package org.example.adv
//import java.lang.System

fun main(){
    val numbs = mutableListOf<String>()
    numbs.add("elychi")
    numbs.add("ginger")
    numbs.add("oolong")
    numbs.add("earl gray")

    numbs.forEach { it -> println(it) }


    val input = readln()

//    val s = reverse(input)
//    println("reverse string is -> $s")
    val re = input.reverse()
    println(re)

}

// extension functions
fun String.reverse(): String {
    return buildString {
        for(i in this@reverse.lastIndex downTo 0){
            append(this@reverse[i])
        }
    }
//    return finalString
}



//fun reverse(s: String): Any {
//    return buildString {
//        for(i in s.lastIndex downTo 0){
//            append(s[i])
//        }
//    }
////    return finalString
//}