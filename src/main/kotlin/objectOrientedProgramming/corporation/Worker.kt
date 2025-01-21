package org.example.objectOrientedProgramming.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val workerType: WorkerType,
    val salary: Int = 15000
) {
    abstract fun copy(age: Int = this.age, salary: Int = this.salary): Worker

    abstract fun work()

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, WorkerType: ${workerType.title}, Salary: $salary."
    }

    fun printInfo() {
        println(this)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Worker) return false
        return this.id == other.id && this.name == other.name && this.workerType == other.workerType && this.age == other.age
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}