package org.example.objectOrientedProgramming.corporation

import objectOrientedProgramming.corporation.Director
import java.io.File

object WorkersRepository {

    private val fileWorkers = File("src\\main\\kotlin\\objectOrientedProgramming\\corporation\\employees.txt")

    private val _workers = loadAllEmployees()

    val workers
        get() = _workers.toList()

    fun registerNewEmployee(worker: Worker){
        _workers.add(worker)
    }

    fun saveChanges(){
        var content = StringBuilder()
        for (worker in _workers){
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.workerType}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    private fun loadAllEmployees(): MutableList<Worker> {
        val workers = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()){
            return workers
        }

        val workersAsString = content.split("\n")
        for (workerAsString in workersAsString) {
            val properties = workerAsString.split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val type = properties.last()

            val workerType = WorkerType.valueOf(type)
            val worker = when (workerType) {
                WorkerType.DIRECTOR -> {
                    Director(id, name, age, salary)
                }
                WorkerType.ACCOUNTANT -> {
                    Accountant(id, name, age, salary)
                }
                WorkerType.ASSISTANT -> {
                    Assistant(id, name, age, salary)
                }
                WorkerType.CONSULTANT -> {
                    Consultant(id, name, age, salary)
                }
            }
            workers.add(worker)
        }
        return workers
    }

    fun removeEmployee(id: Int) {
        val id = readln().toInt()
        for (worker in _workers) {
            if (worker.id == id) {
                _workers.remove(worker)
                break
            }
        }
    }

    fun changeSalary(id: Int, salary: Int){
        for (worker in _workers) {
            if (worker.id == id) {
                worker.setSalary(salary)
            }
        }
    }
}