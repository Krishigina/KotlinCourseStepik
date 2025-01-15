package org.example.objectOrientedProgramming.textMerger

class TextMerger {
    fun mergeText(lines: List<String>): String {
        val result = StringBuilder()
        for (line in lines) {
            result.append(line + "\n")
        }
        return result.toString()
    }
}