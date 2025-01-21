package org.example.objectOrientedProgramming.equals

// Класс с переопределенным методом equals по uniqueCode
class Product(val uniqueCode: String, val name: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false
        return this.uniqueCode == other.uniqueCode
    }

    override fun hashCode(): Int {
        return uniqueCode.hashCode()
    }
}