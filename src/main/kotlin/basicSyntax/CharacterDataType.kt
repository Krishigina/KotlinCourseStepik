package org.example.basicSyntax

fun main() {
    val password = readln().toCharArray()
    var specialLetter = false
    for (symbol in password){
        if (symbol == 'ъ'){
            specialLetter = true
        }
    }
    if (specialLetter){
        println("У вас идеальный пароль!")
    } else {
        println("Опс! В вашем пароле кое-чего не хватает.")
    }
}