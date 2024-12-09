package org.example.objectOrientedProgramming.corporation

import objectOrientedProgramming.corporation.Director

fun main() {
    val assistant = Assistant("Helen", 25)
    val director = Director("Andrey", 25)
    val consultant = Consultant("Max")
    val accountant = Accountant("Christian", 30)
    val employees = listOf<Worker>(director, assistant, consultant, accountant)
    for (employee in employees){
        employee.work()
    }
}