package com.example.masterkotlin.annotationAndSerialization

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

/*
what are annotations in kotlin??
Annotations are special markers/instructions you attach to classes,
functions, properties, etc.,
to give the compiler or other tools extra information about
how to treat that code.
*/

@Composable // this is an annotation
fun Greeting(name: String) {

}

// @Suppress, @Throws, @Deprecated,

/*
Serialization in kotlin:
Serialization = Converting Kotlin objects → JSON/String → to send over API/save to file.
 Deserialization = JSON → Kotlin object.

Think of it like packing/unpacking your data.
*/
@Serializable
class name(){

}

fun main(){

}