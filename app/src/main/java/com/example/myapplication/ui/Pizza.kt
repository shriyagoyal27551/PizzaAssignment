data class Pizza(
    val name: String,
    val size: PizzaSize,
    val crust: PizzaCrust,
    val toppings: MutableList<PizzaTopping>,
    val price: Double
)

enum class PizzaSize {
    REGULAR, MEDIUM, LARGE
}

enum class PizzaCrust {
    HAND_TOSSED, WHEAT_THIN, CHEESE_BURST, FRESH_PAN
}

data class PizzaTopping(
    val name: String,
    val price: Double
)
