package org.example.objectOrientedProgramming.corporation

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    val items = mutableListOf<ProductCard>()
    val file = File("src\\main\\kotlin\\objectOrientedProgramming\\corporation\\product_cards.txt")

    override fun work() {
        while (true) {
            val operationCodes = OperationCode.entries
            print("Enter the operation code.")
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun removeProductCard() {
        val cards = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards){
            saveProductcardToFile(card)
        }
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
        val content = file.readText().trim()
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }


    fun showAllItems() {
        val content = file.readText().trim()
        if (content.isEmpty()){
            return
        }
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val properties = cardAsString.split("%")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            productCard.printInfo()
        }
    }


    fun saveProductcardToFile(productcard: ProductCard) {
        file.appendText("${productcard.name}%")
        file.appendText("${productcard.brand}%")
        file.appendText("${productcard.price}%")
        when (productcard) {
            is FoodCard -> {
                val caloric = productcard.caloric
                file.appendText("$caloric%${ProductType.FOOD}\n")
            }
            is ApplianceCard -> {
                val wattage = productcard.wattage
                file.appendText("$wattage%${ProductType.APPLIANCE}\n")
            }
            is ShoeCard -> {
                val size = productcard.size
                file.appendText("$size%${ProductType.SHOE}\n")
            }
        }
    }


    fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type.")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType: ProductType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        file.appendText("$productName%")
        val productBrand = readln()
        print("Enter the product price: ")
        file.appendText("$productBrand%")
        val productPrice = readln().toInt()
        file.appendText("$productPrice%")
        when (productType) {
            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric%")
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage%")
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                file.appendText("$size%")
            }
        }
        file.appendText("$productType\n")
    }
}
