package org.example.objectOrientedProgramming.introductionToInheritance

class Drill(
    brand: String,
    model: String,
    val drillChuckDiameter: Int,
): PowerTool(brand, model) {
    override fun turnOn(){
        println("Дрель сверлит")
    }
}