package org.example.objectOrientedProgramming.copy

import org.example.objectOrientedProgramming.corporation.Accountant

class Task(
    val id: Int,
    val title: String,
    val description: String,
    val assignedTo: String,
    val status: String,
    val priority: String
) {
    fun printTaskInfo() {
        println("Задача #$id: $title")
        println("Описание: $description")
        println("Назначена: $assignedTo")
        println("Статус: $status")
        println("Приоритет: $priority")
        println()
    }

    fun copy(title: String = this.title, description: String = this.description, assignedTo: String = this.assignedTo, status: String = this.status, priority: String = this.priority): Task {
        return Task(this.id, title, description, assignedTo, status, priority)
    }
}