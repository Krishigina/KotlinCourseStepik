package org.example.multithreading

import org.example.multithreading.singletonCompanionInit.observers.MutableObservable
import org.example.multithreading.singletonCompanionInit.observers.Observable
import org.example.multithreading.singletonCompanionInit.observers.Observer
import kotlin.concurrent.thread
import kotlin.math.round
import kotlin.random.Random

fun interface Observer<T>{

    fun onChanged(newValue: T)
}
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

// Репозиторий данных
object DataRepository {
    var userData: String = "User_Initial"
    var orderData: Int = 100
    var priceData: Double = 99.99

    // Метод обновления данных
    fun updateData(newUser: String? = null, newOrder: Int? = null, newPrice: Double? = null) {
        newUser?.let { userData = it }
        newOrder?.let { orderData = it }
        newPrice?.let { priceData = round(it * 100) / 100 }
    }
}


// Класс для автоматического обновления данных
class DataUpdater(private val repository: DataRepository) {
    init {
        thread {
            while (true) {
                when (Random.nextInt(3)) {
                    0 -> repository.updateData(newUser = "User_${Random.nextInt(1, 100)}")
                    1 -> repository.updateData(newOrder = Random.nextInt(100, 200))
                    2 -> repository.updateData(newPrice = Random.nextDouble(50.0, 150.0))
                }
                val millis = Random.nextLong(10000L)
                Thread.sleep(millis) // Симуляция времени между обновлениями
            }
        }
    }
}



fun main() {
    // Запуск обновления данных
    DataUpdater(DataRepository)

    // Подписка на обновления данных пользователя
    MutableObservable(DataRepository.userData).registerObserver { newValue ->
        println("UserMonitor: Обнаружено изменение данных пользователя: $newValue")
    }

    // Подписка на обновления данных заказов
    MutableObservable(DataRepository.orderData).registerObserver { newValue ->
        println("OrderMonitor: Обнаружено изменение данных заказа: $newValue")
    }

    // Подписка на обновления данных цены
    MutableObservable(DataRepository.priceData).registerObserver { newValue ->
        println("PriceMonitor: Обнаружено изменение цены: $newValue")
    }
}