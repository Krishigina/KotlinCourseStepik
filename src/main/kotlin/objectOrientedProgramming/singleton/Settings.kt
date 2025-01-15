package org.example.objectOrientedProgramming.singleton

object Settings {
    var language: String = "English"
    var theme: String = "Light"
    var notificationsEnabled: Boolean = true

    fun applySettings() {
        println("Применение настроек: язык - $language, тема - $theme, уведомления - ${if (notificationsEnabled) "включены" else "выключены"}")
    }
}