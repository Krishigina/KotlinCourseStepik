package org.example.multithreading.singletonCompanionInit.dogs

import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class Display {

    fun show() {
        val textArea = JTextArea().apply {
            isEditable = false
            font = Font(Font.SANS_SERIF, Font.PLAIN, 16)
            margin = Insets(32, 32, 32, 32)
        }
        val scrollPane = JScrollPane(textArea)
        JFrame().apply {
            isVisible = true
            size = Dimension(600, 600)
            isResizable = false
            add(scrollPane)
        }
        DogsRepository.getInstance("qwerty").dogs.registerObserver {
            textArea.text = it.joinToString("\n")
        }
    }
}