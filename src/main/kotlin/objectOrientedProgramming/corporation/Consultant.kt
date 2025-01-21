package org.example.objectOrientedProgramming.corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    workerType = WorkerType.CONSULTANT,
    salary = salary
), Cleaner {

    fun sayHello() {
        print("Hello! My name is $name")
        if (age > 0) {
            print("I'm $age years old.\n")
        }
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0, 100)
        repeat(count) {
            print("The customers is served..")
        }
        println()
        return count
    }

    override fun copy(age: Int, salary: Int): Consultant {
        return Consultant(this.id, this.name, age, salary)
    }


    override fun work() {
        serveCustomers()
    }

    override fun clean() {
        println("$name, ${workerType.title} - I'm cleaning now")
    }
}