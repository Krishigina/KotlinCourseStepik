package org.example.basicSyntax

fun main() {
    val weight = readln().toInt()

    val cost = when (weight) {
        in 0..<2 -> "150  руб./км."
        in 2..<5 -> "200  руб./км."
        in 5..<12 -> "250  руб./км."
        in 12..<18 -> "300  руб./км."
        in 18..<30 -> "350  руб./км."
        in 30..<200 -> "1000  руб./км."
        else -> "Для расчета стоимости свяжитесь с менеджером"
    }
    println(cost)

}