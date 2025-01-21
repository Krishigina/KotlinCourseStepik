package org.example.objectOrientedProgramming.equals

// Класс с переопределенным методом equals по id
class Person (val id: Int, val name: String) {

    override fun hashCode(): Int {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Person) return false
        return this.id == other.id
    }
}