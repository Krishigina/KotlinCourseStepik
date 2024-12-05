package org.example.objectOrientedProgramming.introductionToInheritance

class AngleGrindel(
    brand: String,
    model: String,
    val discDiameter: Int,
): PowerTool(brand, model) {
    override fun turnOn(){
        println("УШМ режет")
    }
}