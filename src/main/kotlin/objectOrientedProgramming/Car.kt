package org.example.objectOrientedProgramming

class Car {
    var brand = ""
    var model = ""
    var enginePower = 0
    var bodyColor = ""

    //добавьте метод init()

    fun drive(enginePower: Int, brand: String, model: String) {
        if (enginePower >= 120) println("Еду быстро, но недалеко на $brand $model")
        else println("Еду далеко, но небыстро на $brand $model")
    }

    fun init(brand: String, model: String, enginePower: Int, bodyColor: String){
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }
}

fun main() {
    val car = Car()
    val data = readln().split(" ")
    car.init(brand = data[0], model = data[1], enginePower = data[2].toInt(), bodyColor = data[3])
    car.drive(enginePower = data[2].toInt(), brand = data[0], model = data[1])
}