package org.example.objectOrientedProgramming.corporation

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    open val salary: Int = 15000,
    val workerType: WorkerType
) {
    abstract fun copy(age: Int = this.age, salary: Int = this.salary): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }
}