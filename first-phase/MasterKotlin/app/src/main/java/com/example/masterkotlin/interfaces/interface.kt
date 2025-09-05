package com.example.masterkotlin.interfaces


// how to create
interface Animal {
    fun makeSound(){
        println("Animal makes a sound")
    }
    fun isFly()
}

interface isOk{
    fun isOk()
}

// conflicts in the interfaces
interface A{
    fun show(){}
}
interface B{
    fun show(){}
}
class Dog: Animal,isOk,A,B{
    override fun isFly() {
        println("Dog can't fly")
    }
    override fun isOk(){
        println("hello i am ok")
    }

    override fun show() {
        super<B>.show()
    }

}


fun main(){

    val dog = Dog()
    dog.makeSound()
    dog.isFly()

}