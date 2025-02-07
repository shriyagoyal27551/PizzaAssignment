class PizzaMenu {

    val pizzas = listOf(
        Pizza("Deluxe Veggie", PizzaSize.REGULAR, PizzaCrust.HAND_TOSSED, mutableListOf(), 150.0),
        Pizza("Cheese and Corn", PizzaSize.REGULAR, PizzaCrust.HAND_TOSSED, mutableListOf(), 175.0),
        Pizza("Paneer Tikka", PizzaSize.REGULAR, PizzaCrust.HAND_TOSSED, mutableListOf(), 160.0),
        Pizza("Non-Veg Supreme", PizzaSize.REGULAR, PizzaCrust.HAND_TOSSED, mutableListOf(), 190.0),
        Pizza("Chicken Tikka", PizzaSize.REGULAR, PizzaCrust.HAND_TOSSED, mutableListOf(), 210.0),
        Pizza("Pepper Barbecue Chicken", PizzaSize.REGULAR, PizzaCrust.HAND_TOSSED, mutableListOf(), 220.0)
    )

    val crustTypes = listOf(PizzaCrust.HAND_TOSSED, PizzaCrust.WHEAT_THIN, PizzaCrust.CHEESE_BURST, PizzaCrust.FRESH_PAN)

    val toppings = listOf(
        PizzaTopping("Black Olive", 20.0),
        PizzaTopping("Capsicum", 25.0),
        PizzaTopping("Paneer", 35.0),
        PizzaTopping("Mushroom", 30.0),
        PizzaTopping("Fresh Tomato", 10.0),
        PizzaTopping("Chicken Tikka", 35.0),
        PizzaTopping("Barbeque Chicken", 45.0),
        PizzaTopping("Grilled Chicken", 40.0)
    )

    val sides = listOf("Cold Drink" to 55.0, "Mousse Cake" to 90.0)
}
