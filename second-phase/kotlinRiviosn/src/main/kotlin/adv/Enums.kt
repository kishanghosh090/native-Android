package org.example.adv

enum class Enums(val s: String) {
    SUNDAY("S"),
    MONDAY("M"),
    TUE("T"),
    WED("W"),
    THU("TH"),
    FRI("F"),
    SAT("SA")
}

fun main(){
    print(Enums.SAT.s)
}