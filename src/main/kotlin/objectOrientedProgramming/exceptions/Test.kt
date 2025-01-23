package org.example.objectOrientedProgramming.exceptions

fun main() {
    try {
        val test = intArrayOf(1, 2, 3, 4)
        for (item in 0..test.size){
            println(test[item])
        }
    } catch (exception: ArrayIndexOutOfBoundsException){
        println("array index out of bounds exceptions")
    }

    // Основная функция программы
    fun processExpressions() {
        val expressions = listOf("10 + 5", "20 / 0", "abc * 5", "15 ^ 2", "30 / 5")

        for (expression in expressions) {
            val result = MathEvaluator.evaluate(expression)
            println("Результат выражения '$expression': $result")
        }
    }
}