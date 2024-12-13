package org.example.objectOrientedProgramming.bank

open class BankAccount(
    private var balance: Int = 0
) {
    fun deposit(amount: Int) {
        balance += amount
    }

    protected fun withdraw(amount: Int) {
        if (amount < 0 || amount > balance){
            return
        }
        balance -= amount
    }

    fun getBalance(): Int {
        return balance
    }
}