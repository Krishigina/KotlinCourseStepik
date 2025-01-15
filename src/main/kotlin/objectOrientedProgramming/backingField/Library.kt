package org.example.objectOrientedProgramming.backingField

class Library(val libraryName: String) {
    // Нарушение инкапсуляции: изменяемые списки доступны напрямую
    private val _books = mutableListOf<Book>()
    val books
        get() = _books.toList()
    private val _users = mutableListOf<User>()
    val users
        get() = _users.toList()

    fun addBook(book: Book) {
        _books.add(book)
        println("Книга \"${book.title}\" добавлена в библиотеку.")
    }

    fun addUser(user: User) {
        _users.add(user)
        println("Пользователь ${user.name} добавлен в библиотеку.")
    }

    // Удаление книги по названию
    fun removeBookByTitle(title: String): Boolean {
        val removed = _books.removeIf { it.title == title }
        if (removed) {
            println("Книга \"$title\" удалена из библиотеки.")
        } else {
            println("Книга \"$title\" не найдена в библиотеке.")
        }
        return removed
    }

    // Удаление пользователя по ID
    fun removeUserById(id: Int): Boolean {
        val removed = _users.removeIf { it.id == id }
        if (removed) {
            println("Пользователь с ID $id удален из библиотеки.")
        } else {
            println("Пользователь с ID $id не найден в библиотеке.")
        }
        return removed
    }

    // Вывод списка всех книг
    fun printAllBooks() {
        println("Список книг в библиотеке $libraryName:")
        _books.forEach { println("- ${it.title} by ${it.author}") }
    }

    // Вывод списка всех пользователей
    fun printAllUsers() {
        println("Список пользователей библиотеки $libraryName:")
        _users.forEach { println("- ${it.name}, ID: ${it.id}") }
    }
}