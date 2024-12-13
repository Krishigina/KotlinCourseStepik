package org.example.objectOrientedProgramming.interfaces

class Compressor(
    processorName: String = "Compressor"
): DataProcessor(processorName), Transformable {

    override fun transform(data: String): String {
        val string = "$processorName преобразовал данные: compressed_$data"
        return string
    }

}