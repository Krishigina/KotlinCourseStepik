package org.example.multithreading.singletonCompanionInit.users

import kotlinx.serialization.json.Json
import java.io.File

class UserRepository private constructor() {
    init {
        println("Creating repository...")
    }

    private val fileUser = File("usersRepository.json")

    private val observers = mutableListOf<Display>()

    private val _users = loadUsers()
    val users
        get() = _users.toList()

    private fun loadUsers(): MutableList<User> {
        val content = fileUser.readText().trim()
        return Json.decodeFromString(content)
    }

    private fun notifyObservers(){
        for (observer in observers){
            observer.onChanged(users)
        }
    }

    fun registerObserver(observer: Display){
        observers.add(observer)
        observer.onChanged(users)
    }


    fun addUser(firstName: String, lastName: String, age: Int){
        val id = users.maxOf {it.userId} + 1
        _users.add(User(id, firstName = firstName, lastName = lastName, email = "", gender = Gender.MALE, age = age))
        notifyObservers()
    }
    fun deleteUser(id: Int){
        _users.removeIf {it.userId == id }
        notifyObservers()
    }
    fun saveChanges(){
        fileUser.writeText(Json.encodeToString(_users))
    }

    companion object {
        private var instance = UserRepository() ?: null
        private val lock = Any()

        fun getInstance(password: String): UserRepository {
            val filePassword = File("password_users.txt").readText().trim()
            if (password != filePassword) throw IllegalArgumentException("Wrong password")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return UserRepository().also {
                    instance = it
                }
            }
        }
    }
}