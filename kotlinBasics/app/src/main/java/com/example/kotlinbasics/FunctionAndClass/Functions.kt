package com.example.kotlinbasics.FunctionAndClass

fun add(a: Int, b: Int): Int {
        return a + b
}
val lambdaName: (teaName: String) -> String = { input -> "yahh wait 5 min to get $input" }

val stringModifier: String.() -> String = {
    this.uppercase()
}



fun main(){
//    println(add(2,4))
//    println(lambdaName("alychi tea"))

    val result = "hello".stringModifier()
//    println(result) // HELLO
//    println("alychi tea".stringModifier())


//    val myForm1 = form {
//        field("name") {
//            value = "Kishan"
//        }
//        field("email") {
//            value = "kishan@example.com"
//        }
//        field("roll") {
//            value = "BSDS2025"
//        }
//        field("roll") {
//            value = "BSDS2025"
//        }
//    }

//    myForm1.show()
//    println(myForm1 is Field)
//    println(System.identityHashCode(myForm1))

//
//    doSomething({
//        return@doSomething mayPrint("kisahn")
//    })


    form( block = {
        name = "chai"
        email = "chai@example.com"
    }).show()
}
fun form(block: Form.() -> Unit): Form {
    val myForm = Form()
    println("output" + myForm + myForm.email)
    myForm.block()  // This allows using 'this' inside the block
    
    return myForm
}


class Form {
    var name: String = ""
    var email: String = ""

    fun show() {
        println("Name: $name")
        println("Email: $email")
    }
}


fun mayPrint(name: String){
    println(name)
}
fun doSomething(action: () -> Unit) {
    println("Before doing something")
    action()
    println("After doing something")
}


//// DSL--
//fun form(block: Form.() -> Unit): Form {
//    val form = Form()
//    form.block()
//    return form
//}
//
//
//class Field(val name: String) {
//    var value: String = ""
//
//    fun printField() {
//        println("$name: $value")
//    }
//}
//class Form {
//    private val fields = mutableListOf<Field>()
//
//    fun field(name: String, block: Field.() -> Unit) {
//        val field = Field(name)
//        field.block() // this refers to the field
//        fields.add(field)
//    }
//
//    fun show() {
//        println("---- Form Data ----")
//        fields.forEach { it.printField() }
//    }
//}
