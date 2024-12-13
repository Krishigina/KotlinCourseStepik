package org.example.objectOrientedProgramming.interfaces

abstract class DataProcessor(
    val processorName: String
) {
    open fun procces(data: String): String {
        val string = "Обработчик: $processorName обработал данные."
        return string
    }
}