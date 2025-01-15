package org.example.objectOrientedProgramming.passwordHasher

class PasswordHasher {

    // Метод для хеширования пароля
    fun hashPassword(password: String): String {
        return password.reversed() // Простая симуляция хеширования (не использовать в продакшене)
    }
}