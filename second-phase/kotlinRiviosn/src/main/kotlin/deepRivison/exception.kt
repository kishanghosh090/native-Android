package org.example.deepRivison

fun main(){
//    throw Exception("my Own exception...............")
    try {
        10/0
    }catch (e: Exception){
        print(e)

    }
    try {
        throw Exception("my Own exception...............")
    }catch (e: Exception){
        print(e)
    }
}