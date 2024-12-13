package org.example.objectOrientedProgramming.geometry

class Circle(
    val radius: Double,
    name: String = "Круг"
):Shape(name) {

    override fun area(): Double {
        val areaValue = Math.PI * (radius * radius)
        return rountToTwoDecimals(areaValue)
    }

    override fun perimeter(): Double {
        val perimeterValue = 2 * Math.PI * radius
        return rountToTwoDecimals(perimeterValue)
    }

}