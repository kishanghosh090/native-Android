package com.example.kotlinbasics


data class Potion(
    val name: String,
    val effect: String,
    val potency: Int
)

fun main(){
    val handlingPotion = Potion("Handing Potion", "Healing", 10)
    val invisibilityPotion = Potion("Invisibility Potion", "Invisibility", 5)
    val strengthPotion = Potion("Strength Potion", "Strength", 15)

    val potions = listOf(handlingPotion, invisibilityPotion, strengthPotion)

    println(potions)
}
