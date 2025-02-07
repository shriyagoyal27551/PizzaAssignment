import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class OrderServiceTest {

    private val pizzaMenu = PizzaMenu()
    private val inventory = Inventory()
    private val orderService = OrderService(pizzaMenu, inventory)

    @Test
    fun `test valid pizza order`() {
        val selectedPizzas = listOf(
            pizzaMenu.pizzas[0].copy(
                size = PizzaSize.REGULAR,
                toppings = mutableListOf(pizzaMenu.toppings[0], pizzaMenu.toppings[1])
            )
        )
        val sideOrders = listOf("Cold Drink" to 55.0)
        val totalAmount = orderService.createOrder(selectedPizzas, sideOrders)
        assertEquals(150.0 + 55.0, totalAmount)
    }

    @Test
    fun `test invalid pizza order with non-veg topping on veg pizza`() {
        val selectedPizzas = listOf(
            pizzaMenu.pizzas[0].copy(
                size = PizzaSize.REGULAR,
                toppings = mutableListOf(pizzaMenu.toppings[0], pizzaMenu.toppings[6]) // Non-veg topping
            )
        )
        val sideOrders = listOf("Cold Drink" to 55.0)
        assertFailsWith<IllegalArgumentException> {
            orderService.createOrder(selectedPizzas, sideOrders)
        }
    }
}
