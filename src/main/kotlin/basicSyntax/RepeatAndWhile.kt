package org.example.basicSyntax

fun main() {
    var number = readln().toInt()
    var number2 = number
    var sum = 0
    while (number > 0){
        sum += number
        number--
    }
    println("Сумма чисел от 1 до $number2 равна $sum")
}