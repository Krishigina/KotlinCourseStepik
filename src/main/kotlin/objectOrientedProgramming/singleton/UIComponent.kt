package org.example.objectOrientedProgramming.singleton

class UIComponent {
    private val settings = Settings

    fun updateLanguage(newLanguage: String) {
        settings.language = newLanguage
        println("UIComponent: язык изменен на $newLanguage")
        settings.applySettings()
    }

    // Метод для получения текущего значения языка
    fun getSettingsLanguage(): String {
        return settings.language
    }

    // Метод для получения текущего статуса уведомлений
    fun getSettingsNotificationsEnabled(): Boolean {
        return settings.notificationsEnabled
    }
}