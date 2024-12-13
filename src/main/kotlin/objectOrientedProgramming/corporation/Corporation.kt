package org.example.objectOrientedProgramming.corporation

fun main() {

    val accountant = Accountant(0, "Helen", 25)
    val employees: MutableList<Worker> = accountant.loadAllEmployees()
    for (employee in employees){
        if (employee is Cleaner){
            employee.clean()
        }
        if (employee is Supplier){
            employee.byThing()
        }
    }
}