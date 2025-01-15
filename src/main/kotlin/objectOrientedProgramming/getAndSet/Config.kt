package org.example.objectOrientedProgramming.getAndSet

class Config {
    var timeout = 30
        set(value) {
            if (value < 1 || value > 300) {
                field = 30
                println("Ошибка: Время ожидания должно быть в диапазоне от 1 до 300 секунд. Установлено значение по умолчанию.")
            }
            else field = value
        }
    var maxRetries: Int = 3
        set(value) {
            if (value < 0) {
                field = 3
                println("Ошибка: Максимальное количество повторных попыток не может быть отрицательным. Установлено значение по умолчанию.")
            }
            else field = value
        }
    var loggingLevel: LogLevel = LogLevel.INFO
        set(value) {
            if (value == LogLevel.TRACE ||  value == LogLevel.FATAL) {
                field = loggingLevel
                println("Ошибка: Уровень $value недоступен.")
            }
            else{
                field = value
            }
        }
    val isDebugMode
        get() = loggingLevel == LogLevel.DEBUG
    val isProductionMode
        get() = loggingLevel == LogLevel.ERROR

    fun printConfig(){
        println("Время ожидания: $timeout секунд\n" +
                "Максимальное количество повторных попыток: $maxRetries\n" +
                "Уровень логирования: ${loggingLevel.name}\n" +
                "Режим отладки: $isDebugMode\n" +
                "Режим продакшн: $isProductionMode")
    }

}