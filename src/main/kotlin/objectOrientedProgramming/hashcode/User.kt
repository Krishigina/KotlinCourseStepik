package org.example.objectOrientedProgramming.hashcode

// Класс User - переопределите методы equals и hashCode по userId
class User(
    val userId: Int,
    val name: String,
    val email: String)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false
        return this.userId == other.userId
    }

    override fun hashCode(): Int {
        var result = userId
        return result
    }
}