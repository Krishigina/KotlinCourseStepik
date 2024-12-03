package org.example.objectOrientedProgramming.returnType

fun main() {
    val data = readln().split(" ")
    val deliveryObject = DeliveryObject(
        data[0].toInt(),
        data[1].toInt(),
        data[2].toInt(),
        data[3].toDouble()
    )

    val warehouse = Warehouse()
    warehouse.packCargo(deliveryObject).printInfo()
}