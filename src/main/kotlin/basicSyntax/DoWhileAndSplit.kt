package org.example.basicSyntax

fun main() {
    val numbersAsString = readln()
    val numbers = numbersAsString.split(" ")
    var sum = 0
    for (number in numbers){
        sum += number.toInt()
    }
    println(sum)
}