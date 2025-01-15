package org.example.objectOrientedProgramming.anyToString

fun main() {
    val log1 = LogEvent("User logged in")
    val log2 = LogEvent(404)
    val log3 = LogEvent(UserActions.CLICK_BUTTON)

    println(log1)
    println(log2)
    println(log3)


}