package org.example.multithreading.singletonCompanionInit.users

import kotlinx.serialization.json.Json
import org.example.multithreading.singletonCompanionInit.observers.Observable
import org.example.multithreading.singletonCompanionInit.observers.Observer
import java.io.File

class UserRepository private constructor() : Observable<List<User>> {
    init {
        println("Creating repository...")
    }

    private val fileUser = File("usersRepository.json")

    private val _observers = mutableListOf<Observer<List<User>>>()
    override val observers
        get() = _observers.toList()

    private val _users = loadUsers()

    override fun unRegisterObserver(observer: Observer<List<User>>) {
        _observers.remove(observer)
    }

    private fun loadUsers(): MutableList<User> {
        val content = fileUser.readText().trim()
        return Json.decodeFromString(content)
    }

    override val currentValue: List<User>
        get() = _users.toList()

    override fun registerObserver(observer: Observer<List<User>>) {
        _observers.add(observer)
        observer.onChanged(currentValue)
    }

    fun addOnUsersChangedListener(observer: Observer<List<User>>) {
        registerObserver(observer)
    }

    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = currentValue.maxOf { it.userId } + 1
        _users.add(User(id, firstName = firstName, lastName = lastName, email = "", gender = Gender.MALE, age = age))
        notifyObservers()
    }

    fun deleteUser(id: Int) {
        _users.removeIf { it.userId == id }
        notifyObservers()
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