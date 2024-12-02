package org.example.basicSyntax

fun main() {
    println("is the vehicle a cargo vehicle (true/false): ")
    val truck = readln().toBoolean()
    println("enter the engine power: ")
    val enginePower = readln().toInt()

    val tax: Int = if (enginePower <= 100) {
        if (!truck) 10 else 25
    } else if (enginePower > 250) {
        if (!truck) 150 else 85
    } else if (enginePower > 200) {
        if (!truck) 75 else 65
    } else if (enginePower > 150) {
        if (!truck) 49 else 50
    } else {
        if (!truck) 34 else 40
    }

    val truckName: String = if (truck) "грузовой" else "легковой"

    println(
        "Вид ТС: $truckName автомобиль\n" +
                "Мощность двигателя: $enginePower л.с.\n" +
                "Налоговая ставка: $tax руб./л.с.\n" +
                "Сумма налога: ${enginePower * tax} руб."
    )
}