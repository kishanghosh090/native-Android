package com.example.masterkotlin.classesAndObjects

import com.example.masterkotlin.classesAndObjects.Shape.Circle
import com.example.masterkotlin.classesAndObjects.Shape.Rectangle
import com.example.masterkotlin.classesAndObjects.Shape.Triangle

//class Car{
//
//}
class Person(){
    fun sayHello(){
        println("hello from person")
    }
}
// primary contructor
class Student (val name: String, val age: Int){
    fun display(){
        println("Student name: $name, age: $age")
    }
}
// secondary constructor
class Employee{

    var name: String
    var age: Int
    // secondary constructor
    constructor(name: String, age: Int){
        this.name = name
        this.age = age
    }
    fun display(){
        println("Employee name: ${this.name}, age: ${this.age} ")
    }

}

// init block
class Car{
    init {
        println("Car is created")
    }

}

// Types of classes
// 1. data class
// 2. enum class
// 3. sealed class
// 4. nested class
// 5. inner class
// 6. abstract class
// 7. interface

// data class
data class User(var name: String, var age: Int)

// enum class
enum class Day{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

// sealed class
sealed class Shape{
//    class Circle(var radius: Double): Shape(){
//        fun area(): Double{
//            return Math.PI * radius * radius
//        }
//    }
//    class Rectangle(var length: Double, var width: Double): Shape(){
//        fun area(): Double{
//            return length * width
//        }
//    }
//    class Triangle(var base: Double, var height: Double): Shape(){
//        fun area(): Double{
//            return 0.5 * base * height
//        }
//    }

    class Circle(var radius: Double): Shape()
    class Rectangle(var length: Double, var width: Double): Shape()
    class Triangle(var base: Double, var height: Double): Shape()


}
fun area(shape: Shape) {
    when (shape) {
        is Circle -> println(Math.PI * shape.radius * shape.radius)
        is Rectangle -> println(shape.length *  shape.width)
        is Triangle -> println( 0.5 * shape.base * shape.height)
    }
}

// abstract class

abstract class Animal{
    abstract fun makeSound()
}
class Dog: Animal(){
    override fun makeSound() {
        println("Dog barks")
    }
}

// singleton Object (A class that can have only one object or instance)
object Counter{
    var count: Int = 0
    fun increment(){
        count++
    }
    fun decrement(){
        count--
    }
}


fun main(){
//    var p1 = Person()
//    p1.sayHello()

//    val u1 = User("John", 20)
//    val u2 = User("John", 20)
//    println(u1 == u2)
//    println(u1)
//    println(u2)
//    println(u1.name)
//    println(u1.age)

//    val today = Day.MONDAY
//    println(today)
    val s1 = Shape.Circle(5.0)
//    val s2 = Shape.Rectangle(5.0, 10.0)
//    val s3 = Shape.Triangle(5.0, 10.0)

    val s2 = Shape.Triangle(5.0, 10.0)
    area(s1)



}