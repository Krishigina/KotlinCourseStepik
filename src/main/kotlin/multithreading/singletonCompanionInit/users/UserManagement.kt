package org.example.multithreading.singletonCompanionInit.users

fun main() {
    val display = Display()
    display.show()
    DisplayOldest().show()
    Administrator().work()
}