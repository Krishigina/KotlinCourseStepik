package org.example.objectOrientedProgramming.hashcode

// Примерный класс с правильной реализацией equals и hashCode с несколькими полями
class Customer(val customerId: Int, val name: String, val email: String, val address: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Customer) return false
        return customerId == other.customerId &&
                email == other.email &&
                address == other.address
    }

    override fun hashCode(): Int {
        var result = customerId
        result = 31 * result + email.hashCode()
        result = 31 * result + address.hashCode()
        return result
    }
}