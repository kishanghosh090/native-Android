package com.example.kotlinbasics.FunctionAndClass

import kotlin.reflect.full.findAnnotation

// File: Main.kt
//import kotlin.reflect.

// 1. Create custom annotation
@Target(AnnotationTarget.CLASS)  // Can only be used on classes
@Retention(AnnotationRetention.RUNTIME)  // Available at runtime
annotation class Loggable(val tag: String)


// 2. Use the annotation on a class
@Loggable(tag = "UserActivity")
class UserManager {
    fun login() {
        println("User logged in.")
    }
}


// 3. Use reflection to read the annotation
fun checkLoggable(obj: Any) {
    val kClass = obj::class
    val annotation = kClass.findAnnotation<Loggable>()

    if (annotation != null) {
        println("🔍 [${annotation.tag}]: Class '${kClass.simpleName}' is loggable.")
    } else {
        println("🚫 No @Loggable annotation found on ${kClass.simpleName}.")
    }
}


// 4. Main function to test
fun main() {
    val userManager = UserManager()
    userManager.login()

    // Read annotation metadata
    checkLoggable(userManager)
}
