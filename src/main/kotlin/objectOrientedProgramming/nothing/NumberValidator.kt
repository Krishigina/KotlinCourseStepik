package org.example.objectOrientedProgramming.nothing

/**
 * Класс NumberValidator выполняет проверку чисел.
 */
object NumberValidator {

    /**
     * Завершает выполнение программы или выбрасывает исключение с заданным сообщением.
     * Возвращает тип Nothing.
     */
    fun terminate(message: String): Nothing {
        throw IllegalArgumentException(message)
    }

    /**
     * Проверяет число на корректность.
     * Если число некорректно, вызывает terminate.
     * @return то же число, если данные корректны.
     */
    fun validate(number: Int): Int {
        if (number < 0){
            terminate("Ошибка: Число отрицательное.")
        }
        if (number == 0){
            terminate("Ошибка: Число равно нулю.")
        }
        return number
    }
}

/**
 * Функция обработки числа.
 * Проверяет число с помощью NumberValidator.validate и выводит результат.
 */
fun processNumber(number: Int) {
    try {
        NumberValidator.validate(number)
        println("Число: $number")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}