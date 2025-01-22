package org.example.objectOrientedProgramming.nullableTypes

interface Repository {
    /**
     * Возвращает список пользователей, некоторые элементы или их поля могут быть null.
     */
    fun getUsers(): List<UserData?>
}