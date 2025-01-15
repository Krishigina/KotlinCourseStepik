package org.example.objectOrientedProgramming.getAndSet

fun main() {
    val config = Config()
    config.setTimeout(310)
    config.setMaxRetries(-1)
    config.setLoggingLevel(LogLevel.TRACE)
    config.printConfig()
    config.setLoggingLevel(LogLevel.DEBUG)
    config.printConfig()
}