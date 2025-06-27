package com.example.kotlinbasics.FunctionAndClass
//
//class User(val name: String) {
//    companion object {
//        const val DEFAULT_AGE = 18
//
//    }
//    fun createGuest(): User {
//        return TODO("Provide the return value")
//    }
//}
//
//fun main(){
//    val guest = User.createGuest()
//    println(User.DEFAULT_AGE)
//
//}
//
//private fun User.Companion.createGuest() {
//    TODO("Not yet implemented")
//}
// ---------------------------------------------------------------------------------------------------------------------
//
//data class User(var name: String, val age: Int)
//sealed class AuthState {
//    object Loading : AuthState()
//    data class Success(val user: String) : AuthState()
//    data class Error(val msg: String) : AuthState()
//}
//
//fun main(){
//    val u1 = User("Kishan", 20)
//    val u2 = u1.copy(age = 20)
////    println(u1==u2)
//    u2.name = "Rana"
////    println("$u1\n$u2")
//    val authState = AuthState.Loading
//    println(authState)
//}
//
