package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pizzaMenu = PizzaMenu()
        val inventory = Inventory()
        val orderService = OrderService(pizzaMenu, inventory)

        // Sample pizza order
        val selectedPizzas = listOf(
            pizzaMenu.pizzas[0].copy(
                size = PizzaSize.REGULAR,
                toppings = mutableListOf(pizzaMenu.toppings[0], pizzaMenu.toppings[1])
            ),
            pizzaMenu.pizzas[1].copy(
                size = PizzaSize.MEDIUM,
                toppings = mutableListOf(pizzaMenu.toppings[3])
            )
        )

        // Sample side orders
        val sideOrders = listOf(
            "Cold Drink" to 55.0
        )

        try {
            val totalAmount = orderService.createOrder(selectedPizzas, sideOrders)
            println("Total order amount: Rs. $totalAmount")
        } catch (e: Exception) {
            println("Order Error: ${e.message}")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}