package org.example.basicSyntax

fun main() {
    val start = readln().toInt()
    val end = readln().toInt()
    val numbers = start..end step 8
    for (number in numbers){
        println(number)
    }
}