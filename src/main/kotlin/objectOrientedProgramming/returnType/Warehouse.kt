package org.example.objectOrientedProgramming.returnType

class Warehouse {
    fun getPack(deliveryObject: DeliveryObject): Pack{
        var length = deliveryObject.length + 1
        var width = deliveryObject.width + 1
        var heigth = deliveryObject.height + 1
        var weigth = 0.3
        val pack = Pack(
            length = length,
            width = width,
            height = heigth,
            weight = weigth
        )
        return pack
    }

    fun packCargo(deliveryObject: DeliveryObject): Cargo{
        var length = getPack(deliveryObject).length
        var width = getPack(deliveryObject).width
        var height = getPack(deliveryObject).height
        var type = getPack(deliveryObject).type
        var weight = getPack(deliveryObject).weight

        val cargo = Cargo(
            length = length,
            width = width,
            height = height,
            typePackaging = type,
            netWeight = deliveryObject.weight,
            grossWeight = weight + deliveryObject.weight)

        return cargo
    }

}