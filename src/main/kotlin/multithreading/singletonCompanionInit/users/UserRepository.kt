package org.example.multithreading.singletonCompanionInit.users

import kotlinx.serialization.json.Json
import java.io.File

class UserRepository private constructor() {
    init {
        println("Creating repository...")
    }

    private val fileUser = File("usersRepository.json")

    private val _users = loadUsers()
    val users
        get() = _users.toList()

    private fun loadUsers(): MutableList<User> {
        val content = fileUser.readText().trim()
        return Json.decodeFromString(content)
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