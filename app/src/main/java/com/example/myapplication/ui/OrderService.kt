class OrderService(private val pizzaMenu: PizzaMenu, private val inventory: Inventory) {

    fun createOrder(selectedPizzas: List<Pizza>, sideOrders: List<Pair<String, Double>>): Double {
        var totalAmount = 0.0

        // Validate each pizza order based on business rules
        for (pizza in selectedPizzas) {
            if (!validatePizzaOrder(pizza)) {
                throw IllegalArgumentException("Invalid pizza selection: ${pizza.name}")
            }

            if (!inventory.checkInventory(pizza)) {
                throw IllegalStateException("Insufficient inventory for ${pizza.name}")
            }

            // Calculate the price
            totalAmount += pizza.price
            inventory.reduceStock(pizza)
        }

        // Add side order costs
        for (side in sideOrders) {
            totalAmount += side.second
        }

        return totalAmount
    }

    private fun validatePizzaOrder(pizza: Pizza): Boolean {
        // Business rule: Vegetarian pizza cannot have non-veg toppings
        if (pizza.name.contains("Veg") && pizza.toppings.any { it.name.contains("Chicken") || it.name.contains("Barbeque") }) {
            println("Vegetarian pizza cannot have non-veg toppings.")
            return false
        }

        // Business rule: Non-Veg pizza cannot have paneer topping
        if (pizza.name.contains("Non-Veg") && pizza.toppings.any { it.name == "Paneer" }) {
            println("Non-vegetarian pizza cannot have paneer topping.")
            return false
        }

        // Large size pizza can have 2 toppings with no extra cost
        if (pizza.size == PizzaSize.LARGE && pizza.toppings.size > 2) {
            println("Large pizza comes with any 2 toppings at no extra cost.")
            return false
        }

        return true
    }
}
