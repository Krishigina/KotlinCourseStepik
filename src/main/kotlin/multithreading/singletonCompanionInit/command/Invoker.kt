package org.example.multithreading.singletonCompanionInit.command

interface Invoker<T: Command> {
    fun addCommand(command: T)
}