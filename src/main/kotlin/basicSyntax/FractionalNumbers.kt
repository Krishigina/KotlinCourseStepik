package org.example.basicSyntax

fun main() {
    val radius = readln().toDouble()

    println("""
        Радиус: $radius
        Длина окружности: ${2 * 3.14 * radius}
        Площадь круга: ${3.14 * (radius * radius)}
    """.trimIndent())
}