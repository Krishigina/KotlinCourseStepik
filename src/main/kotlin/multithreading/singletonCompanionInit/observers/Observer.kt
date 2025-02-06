package org.example.multithreading.singletonCompanionInit.observers

interface Observer<T> {

    fun onChanged(newValue: T)
}