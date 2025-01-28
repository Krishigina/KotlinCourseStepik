package org.example.multithreading

import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    print("Enter number from 0 to 1_000_000_000: ")
    val number = readln().toLong()
    var guessesNumber: Boolean = false
    thread {
        var seconds = 0
        while (!guessesNumber) {
            seconds++
            println(seconds)
            sleep(1000)
        }
    }
    thread {
        while (!guessesNumber) {
            val random = Random.nextLong(1_000_000_001)
            if (random == number) {
                guessesNumber = true
                print("I win. Your number is: $random")
            }
        }
    }

}

