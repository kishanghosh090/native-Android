package com.example.kotlinbasics

class User(val name: String) {
    companion object {
        const val DEFAULT_AGE = 18

    }
    fun createGuest(): User {
        return TODO("Provide the return value")
    }
}

fun main(){
    val guest = User.createGuest()
    println(User.DEFAULT_AGE)

}

private fun User.Companion.createGuest() {
    TODO("Not yet implemented")
}
