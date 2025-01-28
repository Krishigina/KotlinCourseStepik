package org.example.multithreading.singletonCompanionInit.users

fun main() {
    UserRepository.getInstance("qwerty").users.forEach(::println)
}