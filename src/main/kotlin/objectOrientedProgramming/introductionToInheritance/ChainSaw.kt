package org.example.objectOrientedProgramming.introductionToInheritance

class ChainSaw(
    brand: String,
    model: String,
    val chainSawTireLength: Int,
): PowerTool(brand, model) {
    override fun turnOn(){
        println("Цепная пилка пилит")
    }
}
