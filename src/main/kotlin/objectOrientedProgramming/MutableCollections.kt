package org.example.objectOrientedProgramming

fun main() {
    val listUser = listOf<String>(
        "user0",
        "user1",
        "user2",
        "user3",
        "user4",
        "user5",
        "user6",
        "user7",
        "user8",
        "user9",
        "user10"
    )
    val copyListUser = mutableListOf<String>()
    for (user in listUser) {
        copyListUser.add(user)
    }
    print("Enter the operation on list: ")
    val operation = readln()

    when (operation) {
        "SHOW" -> {
            showList(copyListUser)
        }

        "ADD" -> {
            print("Enter the user name: ")
            val newItem = readln()
            copyListUser.add(newItem)
            showList(copyListUser)
        }

        "REMOVE" -> {
            print("Enter the name of element to remove: ")
            val removeItem = readln()
            copyListUser.remove(removeItem)
            showList(copyListUser)
        }

        "REMOVE_AT" -> {
            print("Enter the index of element to remove: ")
            val removeItem = readln().toInt()
            copyListUser.removeAt(removeItem)
            showList(copyListUser)
        }

        else -> println("Некорректное значение")
    }
}
//
fun showList(list: List<String>) {
    for (user in list) {
        println(user)
    }
}