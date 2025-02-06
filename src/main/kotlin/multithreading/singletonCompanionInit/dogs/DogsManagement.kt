package org.example.multithreading.singletonCompanionInit.dogs

fun main() {
    val display = Display()
    display.show()
    Administrator().work()
}