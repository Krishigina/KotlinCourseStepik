package org.example.objectOrientedProgramming.corporation

class Assistant(
    name: String,
    age: Int
) : Worker(name = name, age = age) {
    fun bringCoffee(count: Int = 1, drinkName: String = "Cappuccino"): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the $drinkName button")
            println("Take $drinkName")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return drinkName
    }

    override fun work() {
        println("I'm answering the phone now..")
    }
}