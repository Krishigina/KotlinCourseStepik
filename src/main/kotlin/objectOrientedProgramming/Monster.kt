package org.example.objectOrientedProgramming

import kotlin.random.Random.Default.nextInt

class Monster {
    val pawsCount: Int
    val eyesCount: Int
    val fangsCount: Int
    val clawsCount: Int
    val tentaclesCount: Int

    constructor(pawsCount: Int, eyesCount: Int, fangsCount: Int, clawsCount: Int, tentaclesCount: Int){
        this.pawsCount = pawsCount
        this.eyesCount = eyesCount
        this.fangsCount = fangsCount
        this.clawsCount = clawsCount
        this.tentaclesCount = tentaclesCount
    }
    constructor(number: Int): this(number, number, number, number, number)

    constructor(){
        this.pawsCount = nextInt(1, 10)
        this.eyesCount = nextInt(1, 10)
        this.fangsCount = nextInt(1, 10)
        this.clawsCount = nextInt(1, 10)
        this.tentaclesCount = nextInt(1, 10)
    }

    fun printInfo(){
        println("""
            Кол-во лап: $pawsCount
            Кол-во глаз: $eyesCount
            Кол-во клыков: $fangsCount
            Кол-во когтей: $clawsCount
            Кол-во щупалец: $tentaclesCount
        """.trimIndent())
    }
}

fun main() {
    val data = readln().split(" ")
    val monster = Monster(data[0].toInt(), data[1].toInt(), data[2].toInt(), data[3].toInt(), data[4].toInt())
    monster.printInfo()
}