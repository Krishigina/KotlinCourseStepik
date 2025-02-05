package org.example.multithreading.singletonCompanionInit

// Ваша задача — сделать этот класс Singleton
class SettingsManager private constructor(context: Context) : BaseManager(context) {

    private val settings: MutableMap<String, String> = mutableMapOf()

    init {
        settings.putAll(context.defaultSettings)
    }

    fun getSetting(key: String): String? {
        return settings[key]
    }

    companion object {
        private var instance: SettingsManager? =  null
        private val lock = Any()

        fun getInstance(context: Context): SettingsManager {
            instance?.let {
                return it
            }
            synchronized(lock) {
                instance?.let {
                    return it
                }
                return SettingsManager(context).also {
                    instance = it
                }
            }
        }
    }
}

open class BaseManager(val context: Context)

data class Context(val name: String, val defaultSettings: Map<String, String>)