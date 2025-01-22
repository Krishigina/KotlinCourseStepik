package org.example.objectOrientedProgramming.corporation

class ShoeCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE) {

}