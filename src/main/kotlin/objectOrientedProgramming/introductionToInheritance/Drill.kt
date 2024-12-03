package org.example.objectOrientedProgramming.introductionToInheritance

class Drill(
    val drillChuckDiameter: Int,
    val minRotationSpeed: Int,
    val maxRotationSpeed: Int,
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cebleLength: Int,
    price: Price,
    voltage: Int
): PowerTool(
    brand = brand,
    model = model,
    power = power,
    weight = weight,
    cebleLength = cebleLength,
    price = price,
    voltage = voltage
) {
}