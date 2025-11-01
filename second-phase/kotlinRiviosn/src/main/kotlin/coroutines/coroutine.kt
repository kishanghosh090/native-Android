//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//
//fun main(): Unit = runBlocking{
//    println("${Thread.currentThread()}")
//
//   val scope: CoroutineScope =  CoroutineScope(Dispatchers.IO)
//    scope.launch {
//        cookFood("kishan")
//    }.join()
//    scope.launch {
//        cookFood("akash")
//    }.join()
//
////    Thread{
////        println("${Thread.currentThread()}")
////        takeOrder("kishan")
////        cookFood("kishan")
////        serveFood("kishan")
////    }.start()
////    Thread{
////        println("${Thread.currentThread()}")
////        takeOrder("akash")
////        cookFood("akash")
////        serveFood("akash")
////    }.start()
//
//}
//
//fun takeOrder(name: String){
//    println("Order taken successfully from $name")
//}
//suspend fun cookFood(name: String){
//    println("Cooking...$name")
//    Thread.sleep(10000)
//}
//fun serveFood(name: String){
//    println("Food serve $name")
//}