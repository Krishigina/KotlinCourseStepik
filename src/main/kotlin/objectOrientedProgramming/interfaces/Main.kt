package org.example.objectOrientedProgramming.interfaces

fun main(){
    val encryptor = Encryptor()
    println(encryptor.procces("sensetive data"))
    println(encryptor.transform("sensetive data"))

    val compressor = Compressor()
    println(compressor.procces("large data"))
    println(compressor.transform("large data"))

    val logger = Logger("Logger")
    println(logger.procces("log data"))

}