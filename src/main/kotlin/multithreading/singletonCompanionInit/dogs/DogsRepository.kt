package org.example.multithreading.singletonCompanionInit.dogs

import kotlinx.serialization.json.Json
import org.example.multithreading.singletonCompanionInit.users.UserRepository
import org.example.multithreading.singletonCompanionInit.users.UserRepository.Companion
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
        private var instance : DogsRepository? = null
        private val lock = Any()

        fun getInstance(password: String): DogsRepository {
            val filePassword = File("password_dogs.txt").readText().trim()
            if (password != filePassword) throw IllegalArgumentException("Wrong password")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return DogsRepository().also {
                    instance = it
                }
            }
        }
    }
}