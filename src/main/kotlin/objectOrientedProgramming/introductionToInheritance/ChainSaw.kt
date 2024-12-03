package org.example.objectOrientedProgramming.introductionToInheritance

class ChainSaw(
    val chainSawTireLength: Int,
    val chainLinksCount: Int,
    val chainStep: Double,
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