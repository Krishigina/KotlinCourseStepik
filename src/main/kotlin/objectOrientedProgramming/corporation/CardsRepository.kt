package org.example.objectOrientedProgramming.corporation

import java.io.File

object CardsRepository {

    private val fileCards = File("src\\main\\kotlin\\objectOrientedProgramming\\corporation\\product_cards.txt")

    private val _cards = loadAllCards()

    val cards
        get() = _cards.toList()

    fun registerNewItem(card: ProductCard){
        _cards.add(card)
    }

    fun saveChanges(){
        var content = StringBuilder()
        for (card in _cards){
            content.append("${card.name}%${card.brand}%${card.price}%")
            when (card) {
                is FoodCard -> {
                    val caloric = card.caloric
                    content.append("$caloric%")
                }
                is ApplianceCard -> {
                    val wattage = card.wattage
                    content.append("$wattage%")
                }
                is ShoeCard -> {
                    val size = card.size
                    content.append("$size%")
                }
            }
            content.append("${card.productType}\n")
        }
        fileCards.writeText(content.toString())
    }

    private fun loadAllCards(): MutableSet<ProductCard> {
        if (!fileCards.exists()) fileCards.createNewFile()
        val _cards = mutableSetOf<ProductCard>()
        val content = fileCards.readText().trim()

        if (content.isEmpty()){
            return _cards
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
            _cards.add(productCard)
        }
        return _cards
    }

    fun removeProductCard(name: String) {
        for (card in _cards) {
            if (card.name == name) {
                _cards.remove(card)
                break
            }
        }
    }
}