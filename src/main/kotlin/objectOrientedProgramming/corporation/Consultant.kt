package org.example.objectOrientedProgramming.corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0
) : Worker(id = id, name = name, age = age, WorkerType.CONSULTANT), Cleaner {

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

    override fun work() {
        serveCustomers()
    }

    override fun clean() {
        println("$name, ${workerType.title} - I'm cleaning now")
    }
}