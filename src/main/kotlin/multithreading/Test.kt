package org.example.multithreading

import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main() {
    thread {
        repeat(100_000){
            print(" * ")
            sleep(1000)
        }
    }
    repeat(100_000){
        print(" 0 ")
        sleep(1000)
    }
}