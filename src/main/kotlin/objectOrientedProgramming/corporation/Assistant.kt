package org.example.objectOrientedProgramming.corporation

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    workerType = WorkerType.ASSISTANT,
    salary = salary
), Cleaner, Supplier {
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

    override fun copy(age: Int, salary: Int): Assistant {
        return Assistant(this.id, this.name, age, salary)
    }

    override fun work() {
        println("I'm answering the phone now..")
    }

    override fun clean() {
        println("$name, ${workerType.title} - I'm cleaning now")
    }
    override fun byThing() {
        println("$name, ${workerType.title} - I'm buying thing now")
    }
}