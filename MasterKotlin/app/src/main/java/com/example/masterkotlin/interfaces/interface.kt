package com.example.masterkotlin.interfaces


// how to create
interface Animal {
    fun makeSound(){
        println("Animal makes a sound")
    }
    fun isFly()
}

class Dog: Animal{
    override fun isFly() {
        println("Dog can't fly")
    }

}


fun main(){

    val dog = Dog()
    dog.makeSound()
    dog.isFly()

}