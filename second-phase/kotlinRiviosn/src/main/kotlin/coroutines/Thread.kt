package org.example.coroutines

fun main(){
   println("${Thread.currentThread()}")

    Thread{
        println("${Thread.currentThread()}")
        takeOrder("kishan")
        cookFood("kishan")
        serveFood("kishan")
    }.start()
    Thread{
        println("${Thread.currentThread()}")
        takeOrder("akash")
        cookFood("akash")
        serveFood("akash")
    }.start()

}

fun takeOrder(name: String){
    println("Order taken successfully from $name")
}
fun cookFood(name: String){
    println("Cooking...$name")
    Thread.sleep(5000)
}
fun serveFood(name: String){
    println("Food serve $name")
}