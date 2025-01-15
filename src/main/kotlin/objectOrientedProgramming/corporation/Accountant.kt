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

    private val file = File("src\\main\\kotlin\\objectOrientedProgramming\\corporation\\product_cards.txt")
    private val empolyees = File("src\\main\\kotlin\\objectOrientedProgramming\\corporation\\employees.txt")

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
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> removeEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun changeSalary(){
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()

        print("Enter new salary: ")
        val salary = readln().toInt()

        val employees = loadAllEmployees()
        empolyees.writeText("")
        for (employee in employees) {
            if (employee.id == id) {
                employee.setSalary(salary)
            }
            saveEmployeeToFile(employee)
        }
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
        saveEmployeeToFile(employee)
    }

    fun saveEmployeeToFile(worker: Worker) {
        empolyees.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.workerType}\n")

    }

    fun loadAllEmployees(): MutableList<Worker> {
        val workers = mutableListOf<Worker>()

        if (!empolyees.exists()) empolyees.createNewFile()

        val content = empolyees.readText().trim()

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

    private fun showAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees){
            employee.printInfo()
        }
    }

    private fun removeEmployee() {
        val employees = loadAllEmployees()
        print("Enter id of employee for removing: ")
        val id = readln().toInt()
        for (employee in employees) {
            if (employee.id == id) {
                employees.remove(employee)
                break
            }
        }
        empolyees.writeText("")
        for (employee in employees){
            saveEmployeeToFile(employee)
        }
    }

    private fun removeProductCard() {
        val cards = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards){
            saveProductcardToFile(card)
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        if (!file.exists()) file.createNewFile()
        val cards = mutableListOf<ProductCard>()
        val content = file.readText().trim()

        if (content.isEmpty()){
            return cards
        }

        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }


    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards){
            card.printInfo()
        }
    }


    private fun saveProductcardToFile(productcard: ProductCard) {
        file.appendText("${productcard.name}%${productcard.brand}%${productcard.price}%")
        when (productcard) {
            is FoodCard -> {
                val caloric = productcard.caloric
                file.appendText("$caloric%")
            }
            is ApplianceCard -> {
                val wattage = productcard.wattage
                file.appendText("$wattage%")
            }
            is ShoeCard -> {
                val size = productcard.size
                file.appendText("$size%")
            }
        }
        file.appendText("${productcard.productType}\n")
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
        saveProductcardToFile(card)
    }

    override fun clean() {
        println("$name, ${workerType.title} - I'm cleaning now")
    }
    override fun byThing() {
        println("$name, ${workerType.title} - I'm buying thing now")
    }
}
