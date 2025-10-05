import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking{
    println("${Thread.currentThread()}")
    launch {
        takeOrder("kishan")
        cookFood("kishan")
        serveFood("kishan")

    }
    launch {
        takeOrder("kishan")
        cookFood("kishan")
        serveFood("kishan")
    }

}

fun takeOrder(name: String){
    println("Order taken successfully from $name")
}
suspend fun cookFood(name: String){
    println("Cooking...$name")
//    Thread.sleep(5000)
    delay(4000)
}
fun serveFood(name: String){
    println("Food serve $name")
}