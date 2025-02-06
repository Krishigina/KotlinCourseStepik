package org.example.multithreading.singletonCompanionInit.dogs

import kotlinx.serialization.json.Json
import org.example.multithreading.singletonCompanionInit.observers.Observer
import java.io.File

class DogsRepository private constructor() {
    init {
        println("Creating repository...")
    }

    private val observers = mutableListOf<Observer<List<Dog>>>()
    private val fileDog = File("dogs.json")

    private val _dogs = loadDogs()
    val dogs
        get() = _dogs.toList()

    private fun loadDogs(): MutableList<Dog> {
        val content = fileDog.readText().trim()
        return Json.decodeFromString(content)
    }

    private fun notifyObservers(){
        for (observer in observers){
            observer.onChanged(dogs)
        }
    }
    fun addOnDogsChangedListener(observer: Observer<List<Dog>>){
        observers.add(observer)
        observer.onChanged(dogs)
    }

    fun addDog(breedName: String, dogName: String, weight: Double){
        val id = dogs.maxOf {it.id} + 1
        _dogs.add(Dog(id, breedName = breedName, dogName = dogName, weight = weight))
        notifyObservers()
    }
    fun deleteDog(id: Int){
        _dogs.removeIf {it.id == id }
        notifyObservers()
    }

    fun saveChanges(){
        fileDog.writeText(Json.encodeToString(_dogs))
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