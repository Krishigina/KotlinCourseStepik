package org.example.objectOrientedProgramming.geometry

class Rectangle(
    val width: Double,
    val heigth: Double,
    name: String = "Прямоугольник"
): Shape(name) {
    override fun area(): Double {
        val areaValue = width * heigth
        return rountToTwoDecimals(areaValue)
    }

    override fun perimeter(): Double {
        val perimeterValue = 2 * (width + heigth)
        return rountToTwoDecimals(perimeterValue)
    }
}