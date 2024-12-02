package org.example.basicSyntax

fun main() {
    println("is the vehicle a cargo vehicle (true/false): ")
    val truck = readln().toBoolean()
    println("enter the engine power: ")
    val enginePower = readln().toInt()

    val tax: Int
    val result: Int

    if (!truck) {
        if (enginePower <= 100){
            tax = 10
            result = enginePower * tax
        } else if (enginePower > 250){
            tax = 150
            result = enginePower * tax
        } else if (enginePower > 200){
            tax = 75
            result = enginePower * tax
        } else if (enginePower > 150){
            tax = 49
            result = enginePower * tax
        } else {
            tax = 34
            result = enginePower * tax
        }
    } else {
        if (enginePower <= 100){
            tax = 25
            result = enginePower * tax
        } else if (enginePower > 250){
            tax = 85
            result = enginePower * tax
        } else if (enginePower > 200){
            tax = 65
            result = enginePower * tax
        } else if (enginePower > 150){
            tax = 50
            result = enginePower * tax
        } else {
            tax = 40
            result = enginePower * tax
        }
    }

    val truckName: String

    if (truck){
        truckName = "грузовой"
    } else {
        truckName = "легковой"
    }

    println("Вид ТС: $truckName автомобиль\n" +
            "Мощность двигателя: $enginePower л.с.\n" +
            "Налоговая ставка: $tax руб./л.с.\n" +
            "Сумма налога: $result руб.")
}