package org.example.adv

import kotlin.math.PI

fun main(){
    val c1 = Circule(10)
    println(c1.r)
    println(c1)

}


interface Shape{
    val area: Double
    val circumfarance: Float
}

fun sum(vararg shapes: Circule){


}
data class Circule(val r:Int): Shape{
    override val circumfarance: Float = 23f
    override val area = PI * (r*r)
}