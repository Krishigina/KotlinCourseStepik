package org.example.basixSyntax

fun main (){
    val a = readln().toInt()
    val result: Int
    val staff: Int

    if (a <= 100){
        result = a * 10
        staff = 10
    } else if (a > 250){
        result = a * 150
        staff = 150
    } else if (a > 200){
        result = a * 75
        staff = 75
    } else if (a > 150){
        result = a * 49
        staff = 49
    } else {
        result = a * 34
        staff = 34
    }

    println("Вид ТС: легковой автомобиль\n" +
            "Мощность двигателя: $a л.с.\n" +
            "Налоговая ставка: $staff руб./л.с.\n" +
            "Сумма налога: $result руб.")
}