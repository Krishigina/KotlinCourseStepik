package org.example.objectOrientedProgramming.introductionToInheritance

class AngleGrindel(
    val diskDiametr: Int,
    val isSmoothStart: Boolean,
    val isDustProtetction: Boolean,
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