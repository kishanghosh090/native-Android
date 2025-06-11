package com.example.masterkotlin.basic_Of_kotlin

fun main(){
    lateinit var name: String
    name = "Ivan"
    println(name)

    val byteVal: Byte = 127 // 8 bit
    val shortVal: Short = 32767
    val intVal: Int = 2147483647
    val longVal: Long = 922565565656565655

    val floatVal: Float = 3.14f
    val doubleVal: Double = 3.141592653589793

    // charectar and string
    val charVal: Char = 'A'
    val stringVal: String = "Hello, world!"

    // bool
    val booleanVal: Boolean = true


    // Array
    val numbers: Array<Int> = arrayOf(12,23,34434)
    val mixedData  = arrayOf("12",34,true)


    // null
    var chai: String? = null // nullable string

    // input from user

    val input = readLine()
    println(input)

    // collections
    // Immutable collections -> cannot be changed -> List( listOf(),List<T>), Set(setOf(), Set<T>), Map(mapOf(), Map<K,V)),
    // Mutable collections -> can be changed -> MutableList(mutableListOf(), MutableList<T>), MutableSet(mutableSetOf(), MutableSet<T>), MutableMap(mutableMapOf(), MutableMap<K,V>)

    val list: List<Int> = listOf(1,2,3,4,5)
    val set: Set<Int> = setOf(1,2,3,4,5)
    val map: Map<String, Int> = mapOf("one" to 1, "two" to 2, "three" to 3)

    val mutableList: MutableList<Int> = mutableListOf(1,2,3,4,5)
    val mutableSet: MutableSet<Int> = mutableSetOf(1,2,3,4,5)
    val mutableMap: MutableMap<String, Int> = mutableMapOf("one" to 1, "two" to 2, "three" to 3)

    mutableList.add(6)
    mutableList.removeAt(0)
    mutableList[0] = 10

    mutableSet.add(6)
    mutableSet.remove(1)

    mutableMap["four"] = 4
    println()





}