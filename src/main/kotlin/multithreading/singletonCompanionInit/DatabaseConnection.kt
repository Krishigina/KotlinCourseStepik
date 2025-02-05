package org.example.multithreading.singletonCompanionInit

class DatabaseConnection private constructor() {

    companion object {
        private var instance: DatabaseConnection? = null
        private val lock = Any()

        fun getInstance(): DatabaseConnection {
            synchronized(lock){
                if (instance == null) {
                    instance = DatabaseConnection()
                }
                return instance!!
            }

        }
    }

    fun query(sql: String): String {
        return "Результат запроса: $sql"
    }
}