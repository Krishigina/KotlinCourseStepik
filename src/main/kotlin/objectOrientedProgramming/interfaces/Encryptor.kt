package org.example.objectOrientedProgramming.interfaces

class Encryptor(
    processorName: String = "Encryptor"
): DataProcessor(processorName), Transformable {

    override fun transform(data: String): String {
        val string = "$processorName преобразовал данные: encoded_$data"
        return string
    }

}