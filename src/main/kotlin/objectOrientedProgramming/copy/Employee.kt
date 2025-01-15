package org.example.objectOrientedProgramming.copy

class Employee(val id: Int, val name: String) {
    private val _tasks = mutableListOf<Task>()
    val tasks
        get() = _tasks.toList()
    private val _archivedTasks = mutableListOf<Task>()
    val archivedTasks
        get() = _archivedTasks.toList()

    fun addTask(task: Task) {
        _tasks.add(task)
        println("Добавлена задача: ${task.title} для сотрудника $name.")
    }

    fun removeTask(taskId: Int) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            _tasks.remove(task)
            println("Задача ${task.title} удалена.")
            _archivedTasks.add(task)
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun updateTaskStatus(taskId: Int, newStatus: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(status = newStatus)
            val index = _tasks.indexOf(task)
            if (index != -1) {
                _tasks[index] = newTask
            }
            println("Статус задачи ${task.title} изменен на '$newStatus'.")
            _archivedTasks.add(task)
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun changeTaskAssignee(taskId: Int, newAssignee: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(assignedTo = newAssignee)
            val index = _tasks.indexOf(task)
            if (index != -1) {
                _tasks[index] = newTask
            }
            println("Задача ${task.title} переназначена на $newAssignee.")
            _archivedTasks.add(task)
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun updateTaskPriority(taskId: Int, newPriority: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(priority = newPriority)
            val index = _tasks.indexOf(task)
            if (index != -1) {
                _tasks[index] = newTask
            }
            println("Приоритет задачи ${task.title} изменен на '$newPriority'.")
            _archivedTasks.add(task)
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun modifyTaskDetails(taskId: Int, newTitle: String, newDescription: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(title = newTitle, description = newDescription)

            val index = _tasks.indexOf(task)
            if (index != -1) {
                _tasks[index] = newTask
            }

            println("Детали задачи ${task.id} обновлены.")
            _archivedTasks.add(task)
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun printTasks() {
        println("Список задач для сотрудника $name:")
        _tasks.forEach { it.printTaskInfo() }
    }
}