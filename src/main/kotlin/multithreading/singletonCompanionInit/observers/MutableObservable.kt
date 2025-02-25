package org.example.multithreading.singletonCompanionInit.observers

class MutableObservable<T>(initialValue: T): Observable<T> {
    override var currentValue: T = initialValue
        set(value) {
            field = value
            notifyObservers()
        }

    private val _observers = mutableListOf<Observer<T>>()
    override val observers: List<Observer<T>>
        get() = _observers.toList()

    override fun registerObserver(observer: Observer<T>){
        _observers.add(observer)
        observer.onChanged(currentValue)
    }

    override fun unRegisterObserver(observer: Observer<T>) {
        _observers.remove(observer)
    }
}