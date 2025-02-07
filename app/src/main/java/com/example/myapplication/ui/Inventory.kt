class Inventory {

    private val ingredientStock = mutableMapOf(
        "Cheese" to 100,
        "Tomato" to 100,
        "Olives" to 100,
        "Paneer" to 100,
        "Chicken" to 100,
        "Mushroom" to 100
    )

    fun checkInventory(pizza: Pizza): Boolean {
        // Checking if required ingredients are available for the pizza
        pizza.toppings.forEach {
            if (ingredientStock[it.name] == null || ingredientStock[it.name]!! <= 0) {
                println("Out of stock: ${it.name}")
                return false
            }
        }
        return true
    }

    fun reduceStock(pizza: Pizza) {
        pizza.toppings.forEach {
            ingredientStock[it.name] = ingredientStock[it.name]!! - 1
        }
    }

    fun restock(ingredient: String, quantity: Int) {
        ingredientStock[ingredient] = ingredientStock.getOrDefault(ingredient, 0) + quantity
    }
}
