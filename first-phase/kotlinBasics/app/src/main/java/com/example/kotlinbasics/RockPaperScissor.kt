package com.example.kotlinbasics

fun main(){
    var computerChoice = ""
    var userChoice: String? = null

    println("Rock Paper or Scissor!!")
    userChoice = readln().lowercase()

    val randomNumber = (1 .. 3).random()
    computerChoice = when(randomNumber){
        1 -> "Rock"
        2 -> "Paper"
        3 -> "Scissor"
        else -> null
    }.toString().lowercase()

    if (userChoice != "rock" && userChoice != "paper" && userChoice != "scissor"){
        println("Invalid input")
        return
    }
    if (userChoice == computerChoice){
        println("Draw match")
    }else if (userChoice == "rock" && computerChoice == "scissor"){
        println("User win")
    }else if (userChoice == "paper" && computerChoice == "rock"){
        println("User win")
    }else if (userChoice == "scissor" && computerChoice == "paper"){
        println("User win")
    }else if (userChoice == "scissor" && computerChoice == "rock"){
        println("computer win")
    }else if (userChoice == "rock" && computerChoice == "paper"){
        println("computer win")
    }else if (userChoice == "paper" && computerChoice == "scissor"){
        println("computer win")
    }
    else{
        println("problem in game")
    }

}