package org.example.deepRivison

fun main(){
    println(myOwnFun("hello from kishan"))
}


fun myOwnFun(s: String): String {
    println("hello from chai aur code")
    return  buildString{
        for (i in s.lastIndex downTo 0){
            append(s[i])
        }
    }

}