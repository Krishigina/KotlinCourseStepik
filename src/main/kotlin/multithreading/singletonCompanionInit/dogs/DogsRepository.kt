package org.example.multithreading.singletonCompanionInit.dogs

import kotlinx.serialization.json.Json
import java.io.File

class DogsRepository private constructor() {
    init {
        println("Creating repository...")
    }

    private val fileDog = File("dogs.json")

    private val _dogs = loadDogs()
    val dogs
        get() = _dogs.toList()

    private fun loadDogs(): MutableList<Dog> {
        val content = fileDog.readText().trim()
        return Json.decodeFromString(content)
    }

    companion object {
        private lateinit var instance: DogsRepository

        fun getInstance(password: String): DogsRepository {
            val filePassword = File("password_dogs.txt").readText().trim()
            if (password != filePassword) throw IllegalArgumentException("Wrong password")
            if (!::instance.isInitialized) {
                return DogsRepository()
            }
            return instance
        }
    }

}