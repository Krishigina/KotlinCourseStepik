package org.example.objectOrientedProgramming

data class Order(
    val id: Int,
    val status: String,
    val type: String
)
fun main() {
    var orders = mutableListOf<Order>()
    while (true) {
        print("Enter code operation. 0 - Exit, 1 - Add order, 2 - Remove completed Order, 3 - Show all orders: ")
        val operation = readln().toInt()
        when (operation) {
            0 -> {
                break
            }
            1 -> {
                print("To add order enter id order: ")
                val id = readln().toInt()
                print("Enter status order: ")
                val status = readln()
                print("Enter type order: ")
                val type = readln()
                val order = Order(id, status, type)
                orders.add(order)
            }
            2 -> {
                print("Enter the type to Remove: ")
                val typeToRemove = readln()
                orders = removeCompletedOrders(orders, typeToRemove)

            }
            else -> {
                if (orders.isEmpty()) {
                    break
                } else {
                    for (item in orders) {
                        val id = item.id
                        val status = item.status
                        val type = item.type
                        print("$id - $status, $type")
                    }
                    println()
                }
            }
        }
    }
}

fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): MutableList<Order> {
    val ordersMutable = orders.toMutableList()
    for (item in orders) {
        if (item.type == typeToRemove && item.status == "completed") {
            ordersMutable.remove(item)
        }
    }
    return ordersMutable
}