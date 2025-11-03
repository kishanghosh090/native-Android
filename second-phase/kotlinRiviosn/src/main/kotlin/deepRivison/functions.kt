package org.example.deepRivison

fun main(){
    println(myOwnFun("hello from kishan"))
    println(myOwnFun("hello from chai code..."))
    println("hello from chai aur code".myReverseFun())

}


fun String.myReverseFun(): String{
    return buildString {
        for (i in this@myReverseFun.lastIndex downTo 0){
            append(this@myReverseFun[i])
        }
    }
}

fun myOwnFun(s: String = "default value"): String {
    println("hello from chai aur code")
    return  buildString{
        for (i in s.lastIndex downTo 0){
            append(s[i])
        }
    }
}