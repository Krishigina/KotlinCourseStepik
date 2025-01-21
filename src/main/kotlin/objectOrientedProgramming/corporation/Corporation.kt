package org.example.objectOrientedProgramming.corporation

fun main() {

    val workers = WorkersRepository.workers
    for (worker in workers){
        worker.work()
    }
}