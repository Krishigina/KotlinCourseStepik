package org.example.objectOrientedProgramming.singleton

class NotificationComponent {
    private val settings = Settings

    fun toggleNotifications(enable: Boolean) {
        settings.notificationsEnabled = enable
        println("NotificationComponent: уведомления ${if (enable) "включены" else "выключены"}")
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