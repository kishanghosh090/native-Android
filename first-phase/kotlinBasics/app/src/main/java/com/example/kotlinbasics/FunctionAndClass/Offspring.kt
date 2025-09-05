package com.example.kotlinbasics.FunctionAndClass

class Offspring: Secondary(), Archery, Singer {
    override fun archery() {
        super.archery()
        println("archery is a skill from secondary in offspring class")
    }
    override fun sing() {
//        super.sing()
        println("sing is a skill from secondary in offspring class")
    }


}