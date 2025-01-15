package org.example.objectOrientedProgramming.singleton

class Application {
    private val uiComponent = UIComponent()
    private val notificationComponent = NotificationComponent()

    fun run() {
        uiComponent.updateLanguage("Spanish")
        notificationComponent.toggleNotifications(false)
    }
}