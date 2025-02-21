package org.example.multithreading.builder

fun main() {
    val drink = Drink.Builder()
        .type("Tea")
        .build()
    println(drink)
}