package org.example.multithreading.singletonCompanionInit.dogs

import org.example.multithreading.singletonCompanionInit.command.Command
import org.example.multithreading.singletonCompanionInit.command.Invoker
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

object DogsInvoker: Invoker {

    private val commands = LinkedBlockingQueue<Command>()

    init {
        thread {
            while (true) {
                println("Waiting...")
                val command = commands.take()
                println("Executing $command...")
                command.execute()
                println("Executed $command")
            }
        }
    }

    override fun addCommand(command: Command) {
        println("New command: $command")
        commands.add(command)
    }
}