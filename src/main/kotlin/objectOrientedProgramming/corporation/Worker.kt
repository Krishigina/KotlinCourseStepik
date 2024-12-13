package org.example.objectOrientedProgramming.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val workerType: WorkerType
) {
    abstract fun work()

    fun printInfo() {
        println("Id: $id, Name: $name, Age: $age, WorkerType: ${workerType.title}")
    }

}