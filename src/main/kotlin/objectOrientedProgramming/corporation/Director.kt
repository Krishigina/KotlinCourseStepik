package objectOrientedProgramming.corporation

import org.example.objectOrientedProgramming.corporation.Assistant
import org.example.objectOrientedProgramming.corporation.Consultant
import org.example.objectOrientedProgramming.corporation.Worker
import org.example.objectOrientedProgramming.corporation.WorkerType

class Director(
    id: Int,
    name: String,
    age: Int
) : Worker(id = id, name = name, age = age, WorkerType.DIRECTOR) {

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
}