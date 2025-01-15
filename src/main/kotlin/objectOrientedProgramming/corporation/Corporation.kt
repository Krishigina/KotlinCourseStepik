package org.example.objectOrientedProgramming.corporation

fun main() {

    val accountant = Accountant(0, "Helen", 25, 50000)
    accountant.printInfo()
    println(accountant)
    accountant.work()
}