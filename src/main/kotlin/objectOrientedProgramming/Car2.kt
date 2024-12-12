package org.example.objectOrientedProgramming

import org.example.objectOrientedProgramming.corporation.*
import java.io.File

class Car2(
    val make: String,
    val model: String,
    val year: Int,
    val vin: String,
    val color: String,
)

val file = File("car_object.txt")

fun serialize(car: Car2): String {
    file.appendText("${car.make}%")
    file.appendText("${car.model}%")
    file.appendText("${car.year}%")
    file.appendText("${car.vin}%")
    file.appendText(car.color)

    val string = file.readText()

    return string
}

fun deserialize(carAsString: String): Car2 {
    val string = carAsString.split("%")

    val make = string[0]
    val model = string[1]
    val year = string[2].toInt()
    val vin = string[3]
    val color = string.last()

    val car2 = Car2(make, model, year, vin, color)

    return car2
}