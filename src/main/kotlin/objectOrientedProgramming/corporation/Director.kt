package objectOrientedProgramming.corporation

import org.example.objectOrientedProgramming.corporation.*

class Director(
    id: Int,
    name: String,
    age: Int
) : Worker(id = id, name = name, age = age, WorkerType.DIRECTOR), Supplier {

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("Thank you, ${assistant.name}! The $drinkName is very tasty :)")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("Consultant ${consultant.name} served $count clients.")
    }

    override fun work() {
        println("I'm drinking coffee..")
    }

    override fun byThing() {
        println("$name, ${workerType.title} - I'm buying thing now")
    }
}