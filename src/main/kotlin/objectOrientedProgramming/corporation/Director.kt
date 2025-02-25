package objectOrientedProgramming.corporation

import org.example.objectOrientedProgramming.corporation.*

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    workerType = WorkerType.DIRECTOR,
    salary = salary
), Supplier {

    override fun copy(age: Int, salary: Int): Worker {
        return Director(this.id, this.name, age, salary)
    }

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