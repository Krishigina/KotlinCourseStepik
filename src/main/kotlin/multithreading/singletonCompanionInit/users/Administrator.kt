package org.example.multithreading.singletonCompanionInit.users

class Administrator {
    private val usersRepository = UserRepository.getInstance("qwerty")

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
                    usersRepository.saveChanges()
                    break
                }

                Operation.ADD_USER -> addUser()
                Operation.DELETE_USER -> deleteUser()
            }
        }
    }

    private fun addUser() {
        print("Enter first name: ")
        val firstName = readln()
        print("Enter last name: ")
        val lastName = readln()
        print("Enter age: ")
        val age = readln().toInt()
        UsersInvoker.addCommand {
            usersRepository.addUser(firstName, lastName, age)
        }
    }

    private fun deleteUser() {
        print("Enter id: ")
        val id = readln().toInt()
        UsersInvoker.addCommand{
            usersRepository.deleteUser(id)
        }
    }
}