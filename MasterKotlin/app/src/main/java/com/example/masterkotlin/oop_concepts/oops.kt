package com.example.masterkotlin.oop_concepts

import androidx.compose.material3.Card

// 1. Abstraction
// 2 . Encapsulation
// 3. polymorphism
// 4. Inheritance

// Abstraction----------------------------------------------------------------------------------
abstract class Vechicle{
    abstract fun start() // abstract method must be implemented in the child class
    fun stop(){
        println("Stoping the vechicle")
    }
}
class Car: Vechicle(){
    override fun start() {
        println("Starting the car")
    }
}

interface Flyable{
    fun fly()
}

class Brid: Flyable {
    override fun fly() {
        println("Brid is flying")
    }
}

/// encapsulation in kotlin--------------------------------------------------
// private(only in the class), public(access from anywhere), protected(access from the class and its child class), internal( only in the module )

class Person{
    private var name: String = ""
    fun setName(name: String){
        this.name = name
    }
    fun getName(): String{
        return this.name
    }
}

open class ProtectedExample{
    protected val protectedData = "protected data"
    protected fun showData(){
        println(protectedData)
    }
}

class Child: ProtectedExample(){
    fun showProtectedData(){
        showData()
    }
}


// inheritance---------------------------------------------------------------------------------------
// inheritance is the process of creating a new class from an existing class (parent class)
// kotlin can inherit from only one class

// parent class (super class)
//open class Animal{
//    fun eat(){
//        println("Eating")
//    }
//}
//class Dog: Animal(){
//    fun bark(){
//        println("Barking")
//    }
//
//}
// polymorphism---------------------------------------------------------------------------------------
// polymorphism is the ability of an object to take on many forms
// compile time polymorphism (static polymorphism)(method overloading) -> same fun name but different parameters
// runtime polymorphism (dynamic polymorphism)(method overriding) -> same fun name , different implementation in the child class
class  Calculator{
    fun add(a: Int, b: Int): Int{
        return a + b
    }
    fun add(a: Double, b: Double): Double {
        return a + b
    }
    fun add(a: Float, b: Float): Float {
        return a + b
    }
    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }

}

// runtime polymorphism (method overriding)
open class Animal{
    open fun makeSound(){
        println("Animal is making a sound")
    }
}
class Dog: Animal(){
    override fun makeSound(){
        println("Dog is barking")
    }
}

class Cat: Animal(){
    override fun makeSound(){
        println("Cat is meowing")
    }

}

fun main() {
//    val myCar = Car()
//    val obj = Child()
//    obj.showProtectedData()
//    val myDog = Dog()
//    myDog.eat()
//    myDog.bark()


}