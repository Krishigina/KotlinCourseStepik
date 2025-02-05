package org.example.multithreading.baseMultithreading

import kotlin.concurrent.thread

class ThreadRunner {
    fun runThreads(): Map<String, String> {
        val threadInfo = mutableMapOf<String, String>()

        // Добавьте в Map имя главного потока и описание его работы
        val name = Thread.currentThread().name
        threadInfo[name] = "Главный поток, который управляет выполнением"

        // Запустите три потока, добавляя в Map имя потока и описание его работы
        val t1 = thread {
            val name = Thread.currentThread().name
            threadInfo[name] = "Выполняет вычисления 1"
        }
        t1.join()
        val t2 = thread {
            val name = Thread.currentThread().name
            threadInfo[name] = "Выполняет вычисления 2"
        }
        t2.join()
        val t3 = thread {
            val name = Thread.currentThread().name
            threadInfo[name] = "Выполняет вычисления 3"
        }
        t3.join()
        return threadInfo
    }
}