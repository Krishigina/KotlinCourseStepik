package org.example.objectOrientedProgramming.bank

class SpecialBankAccount(
    balance: Int
): BankAccount(balance) {

    fun specialWithDraw(amount: Int){
        withdraw(amount)
    }
}