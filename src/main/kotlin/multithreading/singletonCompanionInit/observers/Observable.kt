package org.example.multithreading.singletonCompanionInit.observers

interface Observable<T> {
    val currentValue: T

    val observers: List<Observer<T>>

    fun registerObserver(observer: Observer<T>)

    fun unRegisterObserver(observer: Observer<T>)

    fun notifyObservers(){
        for (observer in observers){
            observer.onChanged(currentValue)
        }
    }
}