package org.example.objectOrientedProgramming

class Car {
    //сделайте все свойства неизменяемыми
    val brand: String
    val model: String
    val enginePower: Int
    val bodyColor: String

    constructor(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }

    fun printInfo(){
        println("$brand $model $enginePower л.с. $bodyColor")
    }

}

fun task() {
    val data = readln().split(" ")
    val car = Car(data[0], data[1], data[2].toInt(), data[3])
    car.printInfo()

}