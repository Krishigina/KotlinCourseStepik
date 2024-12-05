package org.example.objectOrientedProgramming.introductionToInheritance

open class PowerTool(
    val brand: String,
    val model: String,
) {
    open fun turnOn(){
        println("Электроинструмент включен")
    }
}