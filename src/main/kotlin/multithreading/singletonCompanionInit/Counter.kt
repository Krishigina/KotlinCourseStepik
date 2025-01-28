package org.example.multithreading.singletonCompanionInit

import kotlin.concurrent.thread

fun main() {

    val counter = Counter()

    val thread1 = thread {
        repeat(100_000){
            counter.incriment()
        }
    }
    val thread2 = thread {
        repeat(100_000){
            counter.incriment()
        }
    }
    thread1.join()
    thread2.join()
    println(counter.counter)
}

class Counter{
    private val lock = Any()
    var counter = 0

    fun incriment(){
        synchronized(lock){
            counter++
        }

    }
}