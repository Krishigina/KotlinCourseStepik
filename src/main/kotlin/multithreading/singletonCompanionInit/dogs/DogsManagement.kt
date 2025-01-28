package org.example.multithreading.singletonCompanionInit.dogs

fun main() {
    DogsRepository.getInstance("qwerty").dogs.forEach(::println)
}