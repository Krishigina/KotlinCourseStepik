package org.example.objectOrientedProgramming.corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
) : ProductCard(name, brand, price, ProductType.SHOE) {

    override fun toString(): String {
        return "Name: $name, Brand: $brand, Price: $price, Product type: ${productType.title}, Size: $size\n"
    }
}