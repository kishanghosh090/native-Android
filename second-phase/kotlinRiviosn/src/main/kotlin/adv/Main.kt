package org.example.adv

import kotlin.math.PI

fun main(){
    val c1 = Circule(10)
    println(c1.r)
    println(c1)

}

abstract class Shapes {
    abstract val area: Float
    abstract val circumference : Float

}

interface Shape{
    val area: Float
    val circumference: Float
}

fun sum(vararg shapes: Circule){


}
open class Circule(val r:Int): Shapes(){
    override val circumference: Float = 23f
    override val area = (PI * (r*r)).toFloat()
}