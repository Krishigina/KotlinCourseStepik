package org.example.objectOrientedProgramming.corporation

import objectOrientedProgramming.corporation.Director
import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    workerType = WorkerType.ACCOUNTANT,
    salary = salary
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository

    private val cardsRepository = CardsRepository

    override fun copy(age: Int, salary: Int): Accountant {
        return Accountant(this.id, this.name, age, salary)
    }

    override fun work() {
        while (true) {
            val operationCodes = OperationCode.entries
            println("Enter the operation code.")
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}\n")
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> {
                    workersRepository.saveChanges()
                    cardsRepository.saveChanges()
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> removeEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }
    private fun changeAge(){
        print("Enter employee's id to change age: ")
        val id = readln().toInt()

        print("Enter new age: ")
        val age = readln().toInt()

        workersRepository.changeAge(id, age)
    }

    private fun changeSalary(){
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()

        print("Enter new salary: ")
        val salary = readln().toInt()

        workersRepository.changeSalary(id, salary)
    }

    private fun registerNewEmployee() {
        val workerTypes = WorkerType.entries
        print("Enter the worker type.")
        for ((index, type) in workerTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < workerTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val workerTypeIndex = readln().toInt()
        val workerType: WorkerType = workerTypes[workerTypeIndex]

        print("Enter the worker id: ")
        val workerId = readln().toInt()
        print("Enter the worker name: ")
        val workerName = readln()
        print("Enter the worker age: ")
        val workerAge = readln().toInt()
        print("Enter the worker salary: ")
        val workerSalary = readln().toInt()

        val employee = when (workerType) {
            WorkerType.DIRECTOR -> {
                Director(workerId, workerName, workerAge, workerSalary)
            }

            WorkerType.ACCOUNTANT -> {
                Accountant(workerId, workerName, workerAge, workerSalary)
            }
            WorkerType.ASSISTANT -> {
                Assistant(workerId, workerName, workerAge, workerSalary)
            }
            WorkerType.CONSULTANT -> {
                Consultant(workerId, workerName, workerAge, workerSalary)
            }
        }
        workersRepository.registerNewEmployee(employee)
    }



    private fun showAllEmployees() {
        val employees = workersRepository.workers
        for (employee in employees){
            employee.printInfo()
        }
    }

    private fun removeEmployee() {
        print("Enter id of employee for removing: ")
        val id = readln().toInt()
        workersRepository.removeEmployee(id)

    }

    private fun removeProductCard() {
        print("Enter name of card for removing: ")
        val name = readln()
        cardsRepository.removeProductCard(name)
    }


    private fun showAllItems() {
        val cards = cardsRepository.cards
        for (card in cards){
            card.printInfo()
        }
    }


    private fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type.")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType: ProductType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()
        val card = when (productType) {
            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                FoodCard(productName, productBrand, productPrice, caloric)
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(productName, productBrand, productPrice, wattage)
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(productName, productBrand, productPrice, size)
            }
        }
        cardsRepository.registerNewItem(card)
    }

    override fun clean() {
        println("$name, ${workerType.title} - I'm cleaning now")
    }
    override fun byThing() {
        println("$name, ${workerType.title} - I'm buying thing now")
    }
}
