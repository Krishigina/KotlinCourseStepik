package org.example.objectOrientedProgramming.corporation

import java.io.File

fun main() {

    val accountant = Accountant(0, "Helen", 25)
    accountant.saveEmployeeToFile(accountant)
    accountant.work()
}