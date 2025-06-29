package com.example.kotlinbasics.FunctionAndClass


class Person(val name: String, val age: Int = 23){

    init {
        println("Hello, my name is $name and I am $age years old.")
    }
    fun greet(){
        println("Hello, my name is $name and I am $age years old.")
    }

}
data class chaiDetails(
    val name: String,
    val price: Int
)

fun main(){
    val person = Person("Kishan", 20)
//    person.greet()
//    println(person.age)
    val userRepo = Repository<User>()
    userRepo.add(User("Kishan", 18))
    userRepo.add(User("Arjun", 20))

//    val productRepo = Repository<Product>()
//    productRepo.add(Product(1, "Phone"))
//    productRepo.add(Product(2, "Laptop"))

    println(userRepo.getAll())
//    println(productRepo.getAll())
}
data class User(val name: String, val age: Int)
data class Product(val id: Int, val title: String)

class Repository<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    fun getAt(index: Int): T? {
        return items.getOrNull(index)
    }
}


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
