package com.bonzzu.demo.util

object Util {
  //Exercise 1
  //Copy the following exercise in https://play.kotlinlang.org/
  //and find and fix the errors
  fun calculateAverage(numbers: List<Int>): Double {
    var sum = 0.0
    for (i in 0..numbers.size - 1) {
      sum += numbers[i]
      println(sum)
    }
    return sum / numbers.size
  }

  //Exercise 2
  //Given a list of numbers, filter out the even numbers and then
  //double each remaining number using the filter and map functions.
  fun calculateEvenNumbers(numbers: List<Int>): List<Int> {
    val numbers = listOf(
      1,
      2,
      3,
      4
    )
    return numbers
      .filter { it % 2 != 0 }
      .map { it * 2 }
  }

  //Exercise 3
  //Imagine you have a list of bank accounts, each represented by a data class BankAccount
  // with properties accountNumber and balance.
  // Write a Kotlin program that uses the reduce function to calculate the total balance
  // across all bank accounts.
  val list = listOf(
    BankAccount(
      accountNumber = "1",
      balance = 10.5
    ),
    BankAccount(
      accountNumber = "2",
      balance = 20.5
    ),
    BankAccount(
      accountNumber = "3",
      balance = 30.5
    )
  )

  fun calculateBalance(accountsList: List<BankAccount>): Double {

    return  accountsList
      .map { it.balance }
      .reduce { sum, balance -> sum + balance }

  }

  data class BankAccount(
    val accountNumber: String,
    val balance: Double,
  )
  //Exercise 4
  //Implement a function that makes an HTTP request using Retrofit to get the name and game_index,
  //handling possible errors and success responses
  //You can use this API -> https://pokeapi.co/

}