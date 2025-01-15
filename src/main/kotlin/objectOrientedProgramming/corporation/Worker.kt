package org.example.objectOrientedProgramming.corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val workerType: WorkerType,
    private var salary: Int = 15000
) {

    fun setSalary(salary: Int) {
        if (salary < this.salary) {
            println("The new salary is too small..")
        } else {
            this.salary = salary
        }
    }
    fun getSalary() = this.salary

//    fun setSalary(salary: Int){
//        if (salary < this.salary){
//            println("The new salary is too small..")
//        } else {
//            this.salary = salary
//        }
//    }
//    fun getSalary():Int{
//        return this.salary
//    }

    abstract fun work()

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, WorkerType: ${workerType.title}, Salary: $salary."
    }

    fun printInfo() {
        println(this)
    }

}