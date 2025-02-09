package org.example.multithreading.singletonCompanionInit.users

import kotlinx.serialization.json.Json
import org.example.multithreading.singletonCompanionInit.observers.MutableObservable
import java.io.File

class UserRepository private constructor(){

    init {
        println("Creating repository...")
    }

    private val fileUser = File("usersRepository.json")

    private val _users = loadUsers()

    val users = MutableObservable(_users.toList())

    val oldestUser = MutableObservable(_users.maxBy { it.age })

    private fun loadUsers(): MutableList<User> {
        val content = fileUser.readText().trim()
        return Json.decodeFromString(content)
    }

    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = _users.maxOf { it.userId } + 1
        val user = User(
            id,
            firstName = firstName,
            lastName = lastName,
            email = "",
            gender = Gender.MALE,
            age = age
        )
        _users.add(user)
        users.currentValue = _users.toList()
        if (age > oldestUser.currentValue.age){
            oldestUser.currentValue = user
        }
    }

    fun deleteUser(id: Int) {
        _users.removeIf { it.userId == id }
        users.currentValue = _users.toList()
        val newOldest = _users.maxBy {it.age}
        if (newOldest != oldestUser.currentValue){
            oldestUser.currentValue = newOldest
        }
    }

    fun saveChanges() {
        fileUser.writeText(Json.encodeToString(_users))
    }

    companion object {
        private var instance: UserRepository? = null
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