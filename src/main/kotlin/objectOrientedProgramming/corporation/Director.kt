package objectOrientedProgramming.corporation

import org.example.objectOrientedProgramming.corporation.Assistant
import org.example.objectOrientedProgramming.corporation.Consultant
import org.example.objectOrientedProgramming.corporation.Worker

class Director(
    name: String,
    age: Int
) : Worker(name = name, age = age) {

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