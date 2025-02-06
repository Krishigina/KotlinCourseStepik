package org.example.multithreading.singletonCompanionInit.dogs

class Administrator {
    private val dogsRepository = DogsRepository.getInstance("qwerty")

    fun work() {
        while (true) {
            val operationCodes = Operation.entries
            print("Enter an operation: ")
            for ((index, operation) in Operation.entries.withIndex()) {
                print("$index - ${operation.title}")
                if (index < operationCodes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }
            val numberOperation = readln().toInt()
            val operationCode = operationCodes[numberOperation]
            when (operationCode) {
                Operation.EXIT -> {
                    dogsRepository.saveChanges()
                    break
                }
                Operation.ADD_USER -> addDog()
                Operation.DELETE_USER -> deleteDog()
            }
        }
    }

    private fun addDog(){
        print("Enter breed name: ")
        val breedName = readln()
        print("Enter dog name: ")
        val dogName = readln()
        print("Enter weight: ")
        val weight = readln().toDouble()
        dogsRepository.addDog(breedName, dogName, weight)
    }

    private fun deleteDog(){
        print("Enter id: ")
        val id = readln().toInt()
        dogsRepository.deleteDog(id)
    }
}