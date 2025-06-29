package com.example.kotlinbasics.Lists

//fun main(){
//    val shoppingList = listOf("Processor","ram","graphics card","SSD") // immutable list
//    val shoppingMulable = mutableListOf("Processor","ram","graphics card","SSD") // mutable list
//    shoppingMulable.add("mother board")
//    shoppingMulable.remove("ram")
//    shoppingMulable.removeAt(0)
//
//    println("is contain " + shoppingMulable.contains("SSD"))
//
//    println("is contain " + shoppingMulable.contains("SSD"))
//    println("is empty " + shoppingMulable.isEmpty())
//    println("size " + shoppingMulable.size)
//
//    for (
//        item in 0 until shoppingList.size
//    ){
//        println("$item " + shoppingList[item])
//    }
//    var i = 0
//    while (i < shoppingMulable.size){
//        println(shoppingMulable[i])
//        i++
//    }
//    println("----------end---------------")
//    shoppingList.forEach { value ->
//        println(value)
//    }
//}

class BankAccount(var accountHolder: String,var Balance: Double){
    private val transactionHistory = mutableListOf<String>()

    fun deposit(amount: Double){
        Balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }
    fun withDraw(amount: Double){
        if (amount <= Balance) {
            Balance -= amount
            transactionHistory.add("$accountHolder withdraw $$amount")
        }else{
            println("insufficient balance")
        }

    }
    fun displayTransactionHistory(){
        println("Transaction History for $accountHolder:")
        transactionHistory.forEach { transaction ->
            println(transaction)
        }
    }
}

fun main(){
    val myBankAccount = BankAccount("kishan", 1000000.0)
    println(myBankAccount.accountHolder )
    
}