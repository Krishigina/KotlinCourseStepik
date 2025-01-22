package org.example.objectOrientedProgramming.nullableTypes

class UserViewModel(private val repository: Repository) {

    /**
     * Реализуйте метод getUserDescriptions, который:
     * 1. Получает данные из репозитория.
     * 2. Удаляет null элементы списка.
     * 3. Заменяет null значения в полях name, email и age на дефолтные.
     * 4. Формирует строки в формате: "Name: [name], Email: [email], Age: [age]".
     *
     * @return Список строк с описаниями пользователей.
     */
    fun getUserDescriptions(): List<String> {
        val users = repository.getUsers()
        val preList: MutableList<String> = mutableListOf()

        for (user in users) {
            if (user == null) {
                continue
            }

            var name = user.name
            var email = user.email
            var age = user.age

            if (name == null) {
                name = "Unknown Name"
            }
            if (email == null) {
                email = "Unknown Email"
            }
            if (age == null) {
                age = 0
            }

            val string = "Name: $name, Email: $email, Age: $age"
            preList.add(string)
        }
        return preList
    }
}