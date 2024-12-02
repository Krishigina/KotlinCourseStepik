package org.example.basicSyntax

fun main() {
    val month = listOf<String>("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    val number = readln().toInt()
    if (number in 1..12) println(month[number-1])
    else println("Incorrect data")
}