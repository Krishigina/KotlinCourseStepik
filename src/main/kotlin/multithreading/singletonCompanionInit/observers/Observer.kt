package org.example.multithreading.singletonCompanionInit.observers

fun interface Observer<T> {

    fun onChanged(newValue: T)
}