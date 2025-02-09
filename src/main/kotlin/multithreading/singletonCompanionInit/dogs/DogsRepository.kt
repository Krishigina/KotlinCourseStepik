package org.example.multithreading.singletonCompanionInit.dogs

import kotlinx.serialization.json.Json
import org.example.multithreading.singletonCompanionInit.observers.MutableObservable
import org.example.multithreading.singletonCompanionInit.observers.Observable
import org.example.multithreading.singletonCompanionInit.observers.Observer
import java.io.File

class DogsRepository private constructor() {
    init {
        println("Creating repository...")
    }

    private val fileDog = File("dogs.json")

    private val dogsList = loadDogs()

    private val _dogs = MutableObservable(dogsList.toList())
    val dogs: Observable<List<Dog>>
        get() = _dogs


    private fun loadDogs(): MutableList<Dog> {
        val content = fileDog.readText().trim()
        return Json.decodeFromString(content)
    }

    fun addDog(breedName: String, dogName: String, weight: Double){
        val id = dogsList.maxOf {it.id} + 1
        dogsList.add(Dog(id, breedName = breedName, dogName = dogName, weight = weight))
        _dogs.currentValue = dogsList.toList()
    }
    fun deleteDog(id: Int){
        dogsList.removeIf {it.id == id }
        _dogs.currentValue = dogsList.toList()
    }

    fun saveChanges(){
        fileDog.writeText(Json.encodeToString(dogsList))
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