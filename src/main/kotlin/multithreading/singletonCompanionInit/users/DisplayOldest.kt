package org.example.multithreading.singletonCompanionInit.users

import org.example.multithreading.singletonCompanionInit.observers.Observer
import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class DisplayOldest {

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
        UserRepository.getInstance("qwerty").oldestUser.registerObserver {
            textArea.text = "Oldest person is: $it"
        }
    }
}