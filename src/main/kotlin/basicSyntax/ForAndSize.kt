package org.example.basicSyntax

fun main() {
    val brands = listOf("Brand1", "Brand2", "Brand3")
    val mark = readln()
    var foundMark = false
    for (brand in brands){
        if (mark == brand){
            foundMark = true
            break
        }
    }
    println(foundMark)
}