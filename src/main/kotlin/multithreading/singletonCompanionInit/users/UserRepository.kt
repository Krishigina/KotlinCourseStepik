package org.example.multithreading.singletonCompanionInit.users

import kotlinx.serialization.json.Json
import org.example.multithreading.singletonCompanionInit.observers.MutableObservable
import org.example.multithreading.singletonCompanionInit.observers.Observable
import java.io.File

class UserRepository private constructor(){

    init {
        println("Creating repository...")
    }

    private val fileUser = File("usersRepository.json")

    private val userList = loadUsers()

    private val _users = MutableObservable(userList.toList())

    val users: Observable<List<User>>
        get() = _users

    private val _oldestUser = MutableObservable(userList.maxBy { it.age })

    val oldestUser: Observable<User>
        get() = _oldestUser

    private fun loadUsers(): MutableList<User> {
        val content = fileUser.readText().trim()
        return Json.decodeFromString(content)
    }

    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = userList.maxOf { it.userId } + 1
        val user = User(
            id,
            firstName = firstName,
            lastName = lastName,
            email = "",
            gender = Gender.MALE,
            age = age
        )
        userList.add(user)
        _users.currentValue = userList.toList()
        if (age > _oldestUser.currentValue.age){
            _oldestUser.currentValue = user
        }
    }

    fun deleteUser(id: Int) {
        userList.removeIf { it.userId == id }
        _users.currentValue = userList.toList()
        val newOldest = userList.maxBy {it.age}
        if (newOldest != _oldestUser.currentValue){
            _oldestUser.currentValue = newOldest
        }
    }

    fun saveChanges() {
        fileUser.writeText(Json.encodeToString(userList))
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